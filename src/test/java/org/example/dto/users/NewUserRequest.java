package org.example.dto.users;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
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
