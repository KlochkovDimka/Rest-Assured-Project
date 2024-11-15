package org.example.dto.users;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class NewUserRequest {
    private CustomData customData;
    @SerializedName("first_name")
    private String firstName;
    private String surname;
    private String email;
    private String username;
    @SerializedName("plain_password")
    private String plainPassword;
    private String roles;
}
