package by.minsk.ussr.api.auth.dto;

import lombok.Data;

@Data
public class UserProfileDto {
    private Integer id;
    private String userName;
    private String email;
}
