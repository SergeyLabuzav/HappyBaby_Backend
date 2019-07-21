package by.minsk.ussr.auth.web.mapper;

import by.minsk.ussr.auth.model.User;
import by.minsk.ussr.auth.web.vm.AccountViewModel;

public interface AccountMapper {
    User toEntity(AccountViewModel accountViewModel);

    AccountViewModel toDto(User entity);
}
