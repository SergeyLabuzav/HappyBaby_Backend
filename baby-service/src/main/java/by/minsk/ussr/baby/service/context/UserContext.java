package by.minsk.ussr.baby.service.context;

import by.minsk.ussr.auth.api.dto.UserProfileDto;
import by.minsk.ussr.baby.error.NoUserLoggedInException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class UserContext {

    private UserProfileDto userProfile() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated()) {
            throw new NoUserLoggedInException();
        }
        return (UserProfileDto) authentication.getDetails();
    }

    public Integer userProfileId() {
        return userProfile().getId();
    }
}
