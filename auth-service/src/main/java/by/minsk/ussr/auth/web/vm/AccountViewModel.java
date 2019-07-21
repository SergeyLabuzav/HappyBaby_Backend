package by.minsk.ussr.auth.web.vm;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.validation.constraints.Email;

@Data
@NoArgsConstructor
public class AccountViewModel {
    @NonNull @Email
    private String email;
    @NonNull
    private String login;
    @NonNull
    private String password;
}
