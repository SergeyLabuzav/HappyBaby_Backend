package by.minsk.ussr.auth.web.rest;

import by.minsk.ussr.auth.service.TokenService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("oauth/token")
public class TokenRestController {
    private final TokenService tokenService;

    public TokenRestController(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    @DeleteMapping("/revoke")
    public void revokeToken() {
        tokenService.revokeToken();
    }
}
