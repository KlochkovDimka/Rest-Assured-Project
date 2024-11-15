package org.example.dto.users;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserAuthentication {
    private String username;
    private String password;
}
