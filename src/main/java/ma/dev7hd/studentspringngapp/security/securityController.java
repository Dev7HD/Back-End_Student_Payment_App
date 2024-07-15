package ma.dev7hd.studentspringngapp.security;

import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("/auth")
public class securityController {

    private SecurityService securityService;

    @GetMapping("/profile")
    public Authentication authenticate(Authentication authentication) {
        return authentication;
    }

    @PostMapping("/login")
    public Map<String, String> login(String username, String password) {
        return securityService.login(username, password);
    }
}
