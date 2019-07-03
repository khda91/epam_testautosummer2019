package lesson_jdi.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Users {
    PETER("epam", "1234", "PETER");

    private final String login;
    private final String password;
    private final String fullName;
}
