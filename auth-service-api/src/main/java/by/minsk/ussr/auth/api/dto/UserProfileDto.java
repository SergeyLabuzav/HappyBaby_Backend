package by.minsk.ussr.auth.api.dto;

import lombok.Data;

@Data
public class UserProfileDto {
    private Integer id;
    private String userName;
    private String email;
}
