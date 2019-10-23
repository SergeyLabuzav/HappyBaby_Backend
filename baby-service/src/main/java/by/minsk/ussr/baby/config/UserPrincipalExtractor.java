package by.minsk.ussr.baby.config;

import by.minsk.ussr.baby.web.dto.UserInfo;
import java.util.Map;
import org.springframework.boot.autoconfigure.security.oauth2.resource.PrincipalExtractor;

public class UserPrincipalExtractor implements PrincipalExtractor {
    @Override
    public Object extractPrincipal(Map<String, Object> map) {
        Map<String, Object> userMap = (Map) map.get("user");
        UserInfo userInfo = new UserInfo();
        userInfo.setId((int)(userMap.get("id")));
        userInfo.setEmail((String) (userMap.get("email")));
        userInfo.setUserName((String) (userMap.get("userName")));
        return userInfo;
    }
}
