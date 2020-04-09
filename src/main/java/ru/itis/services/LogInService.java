package ru.itis.services;

import ru.itis.dto.LogInDto;
import ru.itis.dto.TokenDto;

public interface LogInService {
    TokenDto logIn(LogInDto logInData);
}
