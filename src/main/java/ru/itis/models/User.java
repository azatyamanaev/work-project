package ru.itis.models;

import lombok.*;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder()
public class User {
    private Long id;
    private String login;
    private String email;
    private String hashPassword;

    @Enumerated(value = EnumType.STRING)
    private State state;
    @Enumerated(value = EnumType.STRING)
    private Role role;

    public User(String login, String email, String hashPassword) {
        this.login = login;
        this.email = email;
        this.hashPassword = hashPassword;
    }
}
