package br.com.curso.clean_arch.presentation.user;

import br.com.curso.clean_arch.infrastructure.config.JwtUserDetails;
import br.com.curso.clean_arch.infrastructure.config.TokenConfig;
import br.com.curso.clean_arch.infrastructure.dtos.user.LoginRequest;
import br.com.curso.clean_arch.infrastructure.dtos.user.LoginResponse;
import br.com.curso.clean_arch.infrastructure.persistence.model.UserEntity;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final TokenConfig tokenConfig;

    public AuthController(AuthenticationManager authenticationManager, TokenConfig tokenConfig) {
        this.authenticationManager = authenticationManager;
        this.tokenConfig = tokenConfig;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@Valid  @RequestBody LoginRequest request){
        UsernamePasswordAuthenticationToken userAndToken = new UsernamePasswordAuthenticationToken(
                request.email(), request.password());
        Authentication authentication = authenticationManager.authenticate(userAndToken);
        JwtUserDetails principal = (JwtUserDetails) authentication.getPrincipal();
        String token = tokenConfig.generateToken(principal);
        return ResponseEntity.ok(new LoginResponse(token));
    }
}
