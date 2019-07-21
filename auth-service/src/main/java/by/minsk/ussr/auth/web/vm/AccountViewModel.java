package by.minsk.ussr.auth.web.vm;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
public class AccountViewModel {
    @NonNull private String email;
    @NonNull private String login;
    @NonNull private String password;
}
