package ru.itis.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ru.itis.dto.SignUpDto;
import ru.itis.models.Role;
import ru.itis.models.State;
import ru.itis.models.User;
import ru.itis.repositories.UsersRepository;

import java.util.Optional;

@Component(value = "signUpServiceImpl")
public class SignUpServiceImpl implements SignUpService {

    @Autowired
    @Qualifier(value = "usersRepositoryJdbcTemplateImpl")
    private UsersRepository usersRepository;
    @Autowired
    private EmailSender emailSender;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Boolean signUp(SignUpDto form) {
        Optional<User> clientCandidate;
        User user;
        clientCandidate = usersRepository.findOneByLogin(form.getLogin());
        if (clientCandidate.isEmpty() && !form.getLogin().equals("") && !form.getPassword().equals("") && !form.getEmail().equals("")) {
            user = User.builder()
                    .login(form.getLogin()).email(form.getEmail())
                    .password(passwordEncoder.encode(form.getPassword()))
                    .state(State.NOT_CONFIRMED)
                    .role(Role.USER)
                    .build();
            usersRepository.save(user);
            emailSender.sendNotificationAboutRegistration(form.getLogin());
            return true;
        }
        return false;
    }
}
