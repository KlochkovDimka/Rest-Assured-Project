package org.example.generet;

import com.github.javafaker.Faker;
import org.example.dto.users.CustomData;
import org.example.dto.users.NewUserRequest;
import org.joda.time.LocalDateTime;

import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class GeneratorUserEntity {

    private final Faker fakerUA;
    private final Faker fakerRU;
    private final String nowData;
    private final String afterData;
    private final String beforeData;

    public GeneratorUserEntity() {
        fakerUA = new Faker();
        fakerRU = new Faker(Locale.of("ru"));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        nowData = LocalDateTime.now().toString().formatted(formatter);
        afterData = LocalDateTime.now().plusMonths(1).toString().formatted(formatter);
        beforeData = LocalDateTime.now().minusMonths(1).toString().formatted(formatter);
    }

    public Object[][] findNewUserRequest() {

        String userNameSpec = "@#$%^&=-";

        return new Object[][]{
                {new NewUserRequest(
                        new CustomData(false, nowData, "active_search"),
                        fakerUA.bothify("??!@#"),
                        "",
                        fakerUA.name().firstName(),
                        "",
                        fakerRU.internet().password(),
                        ""
                )},
                {new NewUserRequest(
                        new CustomData(true, beforeData, "on_project"),
                        fakerUA.bothify("??!@#"),
                        fakerUA.name().lastName(),
                        "",
                        fakerRU.name().firstName(),
                        "",
                        "admin"
                )},
                {new NewUserRequest(
                        new CustomData(null, nowData, ""),
                        fakerUA.bothify("??!@#"),
                        fakerUA.bothify("????!@#"),
                        fakerUA.internet().emailAddress(),
                        userNameSpec,
                        fakerUA.internet().password(true),
                        ""
                )},
                {new NewUserRequest(
                        new CustomData(true, afterData, "active_search"),
                        fakerUA.bothify("??!@#"),
                        "",
                        fakerUA.name().firstName(),
                        "",
                        fakerRU.internet().password(),
                        "user"
                )},
                {new NewUserRequest(
                        new CustomData(false, "", "pause_search"),
                        fakerUA.bothify("??!@#"),
                        fakerRU.name().lastName(),
                        fakerRU.name().firstName(),
                        fakerUA.name().firstName(),
                        userNameSpec,
                        ""
                )},
                {new NewUserRequest(
                        new CustomData(null, "2024-08-25T19:01:00.000Z", "on_project"),
                        fakerUA.bothify("??!@#"),
                        fakerUA.name().lastName(),
                        "",
                        fakerRU.name().firstName(),
                        "",
                        "user"
                )},
                {new NewUserRequest(
                        new CustomData(false, "2024-08-25T19:01:00.000Z", ""),
                        "",
                        "",
                        fakerRU.name().firstName(),
                        fakerRU.name().firstName(),
                        fakerUA.internet().password(true),
                        "user"
                )},
                {new NewUserRequest(
                        new CustomData(true, nowData, "pause_search"),
                        "",
                        fakerUA.name().lastName(),
                        fakerUA.internet().emailAddress(),
                        "",
                        userNameSpec,
                        "user"
                )},
                {new NewUserRequest(
                        new CustomData(false, "2024-08-25T19:01:00.000Z", "on_project"),
                        "",
                        fakerUA.bothify("??!@#"),
                        fakerUA.name().firstName(),
                        fakerUA.name().firstName(),
                        "",
                        "admin"
                )},
                {new NewUserRequest(
                        new CustomData(null, beforeData, ""),
                        "",
                        "",
                        fakerRU.name().firstName(),
                        fakerRU.name().firstName(),
                        fakerUA.internet().password(true),
                        ""
                )},
                {new NewUserRequest(
                        new CustomData(true, nowData, "active_search"),
                        "",
                        fakerRU.name().lastName(),
                        "",
                        userNameSpec,
                        fakerRU.internet().password(),
                        "user"
                )},
                {new NewUserRequest(
                        new CustomData(null, afterData, "pause_search"),
                        "",
                        fakerUA.name().lastName(),
                        fakerUA.internet().emailAddress(),
                        "",
                        userNameSpec,
                        "admin"
                )},
                {new NewUserRequest(
                        new CustomData(true, "2024-11-12T19:01:00.000Z", "on_project"),
                        "",
                        fakerUA.bothify("??!@#"),
                        fakerUA.name().firstName(),
                        fakerUA.name().firstName(),
                        "",
                        ""
                )},
                {new NewUserRequest(
                        new CustomData(null, "2024-11-12T19:01:00.000Z", ""),
                        fakerRU.name().firstName(),
                        fakerRU.name().lastName(),
                        fakerUA.internet().emailAddress(),
                        fakerUA.name().firstName(),
                        fakerUA.internet().password(true),
                        "user"
                )},
                {new NewUserRequest(
                        new CustomData(true, "2024-08-25T19:01:00.000Z", "active_search"),
                        fakerRU.name().firstName(),
                        fakerUA.name().lastName(),
                        fakerUA.name().firstName(),
                        fakerRU.name().firstName(),
                        fakerRU.internet().password(),
                        "admin"
                )},
                {new NewUserRequest(
                        new CustomData(false, beforeData, "pause_search"),
                        fakerRU.name().firstName(),
                        fakerUA.name().lastName(),
                        fakerRU.name().firstName(),
                        userNameSpec,
                        userNameSpec,
                        ""
                )},
                {new NewUserRequest(
                        new CustomData(null, nowData, "on_project"),
                        fakerRU.name().firstName(),
                        "",
                        "",
                        "",
                        "",
                        "user"
                )},
                {new NewUserRequest(
                        new CustomData(true, "2024-08-25T19:01:00.000Z", ""),
                        fakerRU.name().firstName(),
                        fakerRU.name().lastName(),
                        fakerUA.internet().emailAddress(),
                        fakerUA.name().firstName(),
                        fakerUA.internet().password(true),
                        ""
                )},
                {new NewUserRequest(
                        new CustomData(false, beforeData, "active_search"),
                        fakerRU.name().firstName(),
                        fakerUA.name().lastName(),
                        fakerUA.name().firstName(),
                        fakerRU.name().firstName(),
                        fakerRU.internet().password(),
                        "user"
                )},
                {new NewUserRequest(
                        new CustomData(null, nowData, "pause_search"),
                        fakerRU.name().firstName(),
                        fakerUA.bothify("??!@#"),
                        fakerRU.name().firstName(),
                        userNameSpec,
                        userNameSpec,
                        "admin"
                )},
                {new NewUserRequest(
                        new CustomData(true, afterData, "on_project"),
                        fakerRU.name().firstName(),
                        "",
                        "",
                        "",
                        "",
                        ""
                )},
                {new NewUserRequest(
                        new CustomData(null, afterData, ""),
                        fakerUA.name().firstName(),
                        fakerUA.name().lastName(),
                        fakerRU.name().firstName(),
                        "",
                        fakerUA.internet().password(true),
                        "user"
                )},
                {new NewUserRequest(
                        new CustomData(true, "", "active_search"),
                        fakerUA.name().firstName(),
                        fakerUA.bothify("??!@#"),
                        "",
                        fakerUA.name().firstName(),
                        fakerRU.internet().password(),
                        "admin"
                )},
                {new NewUserRequest(
                        new CustomData(null, "2024-08-25T19:01:00.000Z", "pause_search"),
                        fakerUA.name().firstName(),
                        "",
                        fakerUA.internet().emailAddress(),
                        fakerRU.name().firstName(),
                        userNameSpec,
                        ""
                )},
                {new NewUserRequest(
                        new CustomData(true, beforeData, "on_project"),
                        fakerUA.name().firstName(),
                        fakerRU.name().lastName(),
                        fakerUA.name().firstName(),
                        userNameSpec,
                        "",
                        "user"
                )},
                {new NewUserRequest(
                        new CustomData(false, nowData, ""),
                        fakerUA.name().firstName(),
                        fakerUA.name().lastName(),
                        fakerRU.name().firstName(),
                        "",
                        fakerUA.internet().password(true),
                        "admin"
                )},
                {new NewUserRequest(
                        new CustomData(null, "2024-08-25T19:01:00.000Z", "active_search"),
                        fakerUA.name().firstName(),
                        fakerUA.bothify("??!@#"),
                        "",
                        fakerUA.name().firstName(),
                        fakerRU.internet().password(),
                        ""
                )},
                {new NewUserRequest(
                        new CustomData(true, beforeData, "pause_search"),
                        fakerUA.name().firstName(),
                        "",
                        fakerUA.internet().emailAddress(),
                        fakerRU.name().firstName(),
                        userNameSpec,
                        "user"
                )},
                {new NewUserRequest(
                        new CustomData(false, nowData, "on_project"),
                        fakerUA.name().firstName(),
                        fakerRU.name().lastName(),
                        fakerUA.name().firstName(),
                        userNameSpec,
                        "",
                        ""
                )},
                {new NewUserRequest(
                        new CustomData(true, nowData, ""),
                        fakerUA.bothify("??!@#"),
                        fakerUA.bothify("??!@#"),
                        fakerUA.internet().emailAddress(),
                        userNameSpec,
                        fakerUA.internet().password(true),
                        ""
                )},
                {new NewUserRequest(
                        new CustomData(false, afterData, "active_search"),
                        fakerUA.bothify("??!@#"),
                        "",
                        fakerUA.name().firstName(),
                        "",
                        fakerRU.internet().password(),
                        "user"
                )},
                {new NewUserRequest(
                        new CustomData(null, "", "pause_search"),
                        fakerUA.bothify("??!@#"),
                        fakerRU.name().lastName(),
                        fakerRU.name().firstName(),
                        "vanyaIvanov",
                        userNameSpec,
                        ""
                )},
                {new NewUserRequest(
                        new CustomData(true, "2024-08-25T19:01:00.000Z", "on_project"),
                        fakerUA.bothify("??!@#"),
                        fakerUA.name().lastName(),
                        "",
                        fakerRU.name().firstName(),
                        "",
                        "user"
                )},
                {new NewUserRequest(
                        new CustomData(null, beforeData, ""),
                        fakerUA.bothify("??!@#"),
                        fakerUA.bothify("??!@#"),
                        fakerUA.internet().emailAddress(),
                        userNameSpec,
                        fakerUA.internet().password(true),
                        "admin"
                )},
                {new NewUserRequest(
                        new CustomData(true, nowData, "active_search"),
                        fakerUA.bothify("??!@#"),
                        "",
                        fakerUA.name().firstName(),
                        "",
                        fakerRU.internet().password(),
                        ""
                )},
                {new NewUserRequest(
                        new CustomData(false, "2024-08-25T19:01:00.000Z", "pause_search"),
                        fakerUA.bothify("??!@#"),
                        fakerRU.name().lastName(),
                        fakerRU.name().firstName(),
                        fakerUA.name().firstName(),
                        userNameSpec,
                        "user"
                )},
                {new NewUserRequest(
                        new CustomData(null, beforeData, "on_project"),
                        fakerUA.bothify("??!@#"),
                        fakerUA.name().lastName(),
                        "",
                        fakerRU.name().firstName(),
                        "",
                        "admin"
                )},
                {new NewUserRequest(
                        new CustomData(false, beforeData, ""),
                        "",
                        "",
                        fakerRU.name().firstName(),
                        fakerRU.name().firstName(),
                        fakerUA.internet().password(true),
                        ""
                )},
                {new NewUserRequest(
                        new CustomData(null, nowData, "active_search"),
                        "",
                        fakerRU.name().lastName(),
                        "",
                        userNameSpec,
                        fakerRU.internet().password(),
                        "user"
                )},
                {new NewUserRequest(
                        new CustomData(true, afterData, "pause_search"),
                        "",
                        fakerUA.name().lastName(),
                        fakerUA.internet().emailAddress(),
                        "",
                        userNameSpec,
                        "admin"
                )},
                {new NewUserRequest(
                        new CustomData(false, "", "on_project"),
                        "",
                        fakerUA.bothify("??!@#"),
                        fakerUA.name().firstName(),
                        fakerUA.name().firstName(),
                        "",
                        ""
                )},
                {new NewUserRequest(
                        new CustomData(null, "2024-08-25T19:01:00.000Z", ""),
                        "",
                        "",
                        fakerRU.name().firstName(),
                        fakerRU.name().firstName(),
                        fakerUA.internet().password(true),
                        "user"
                )},
                {new NewUserRequest(
                        new CustomData(true, beforeData, "active_search"),
                        "",
                        fakerRU.name().lastName(),
                        "",
                        userNameSpec,
                        fakerRU.internet().password(),
                        ""
                )},
                {new NewUserRequest(
                        new CustomData(null, nowData, "pause_search"),
                        "",
                        fakerUA.name().lastName(),
                        fakerUA.internet().emailAddress(),
                        "",
                        userNameSpec,
                        "user"
                )},
                {new NewUserRequest(
                        new CustomData(true, "2024-08-25T19:01:00.000Z", "on_project"),
                        "",
                        fakerUA.bothify("??!@#"),
                        fakerUA.name().firstName(),
                        fakerUA.name().firstName(),
                        "",
                        "admin"
                )}
        };
    }
}
