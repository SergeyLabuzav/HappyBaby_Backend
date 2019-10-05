package by.minsk.ussr.auth.api.dto;

import lombok.Data;

@Data
public class UserProfileDto {
    private long id;
    private String userName;
    private String email;
}
