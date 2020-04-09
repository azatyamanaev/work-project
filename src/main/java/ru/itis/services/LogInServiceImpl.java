package ru.itis.services;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ru.itis.dto.LogInDto;
import ru.itis.dto.TokenDto;
import ru.itis.models.State;
import ru.itis.models.User;
import ru.itis.repositories.UsersRepository;

import java.nio.file.AccessDeniedException;
import java.util.Optional;

@Component(value = "logInServiceImpl")
public class LogInServiceImpl implements LogInService {

    @Autowired
    @Qualifier(value = "usersRepositoryJdbcTemplateImpl")
    private UsersRepository usersRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Value("${jwt.secret}")
    private String secret;

    @SneakyThrows
    @Override
    public TokenDto logIn(LogInDto logInData) {
        Optional<User> userOptional = usersRepository.findOneByLogin(logInData.getLogin());
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            if (passwordEncoder.matches(logInData.getPassword(), user.getPassword())) {
                String token = Jwts.builder()
                        .setSubject(user.getId().toString())
                        .claim("name", user.getLogin())
                        .claim("role", user.getRole().name())
                        .signWith(SignatureAlgorithm.HS256, secret)
                        .compact();
                return new TokenDto(token);
            } else throw new AccessDeniedException("Wrong login/password");
        } else throw new AccessDeniedException("User not found");
    }


}
