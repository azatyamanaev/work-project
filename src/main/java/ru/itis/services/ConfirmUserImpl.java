package ru.itis.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ru.itis.models.State;
import ru.itis.models.User;
import ru.itis.repositories.UsersRepository;

import java.util.Optional;

@Component(value = "confirmUserImpl")
public class ConfirmUserImpl implements ConfirmUser {

    @Autowired
    @Qualifier(value = "usersRepositoryJdbcTemplateImpl")
    private UsersRepository usersRepository;

    @Override
    public void confirm(String login) {
        Optional<User> userOptional = usersRepository.findOneByLogin(login);
        User user;
        if (userOptional.isPresent()) {
            user = userOptional.get();
            user.setState(State.CONFIRMED);
            usersRepository.update(user);
        } else {
            throw new IllegalStateException("User is not present");
        }
    }
}
