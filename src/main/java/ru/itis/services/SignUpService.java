package ru.itis.services;

import ru.itis.dto.SignUpDto;

public interface SignUpService {
    Boolean signUp(SignUpDto form);
}
