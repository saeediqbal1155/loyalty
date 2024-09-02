package com.retail.loyalty.controller.v1;

import com.retail.loyalty.entity.User;
import com.retail.loyalty.service.UserService;
import com.retail.loyalty.util.AuthRequest;
import com.retail.loyalty.util.JwtUtil;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController extends BaseController {
    private final UserService userService;
    private final JwtUtil jwtUtil;
    private final BCryptPasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public Mono<User> register(@RequestBody User user) {
        return userService.registerUser(user);
    }

/*    @PostMapping("/login")
    public Mono<String> login(@RequestBody AuthRequest request) {
        return userService.findByUsername(request.getUsername())
                .flatMap(user -> {
                    if (user != null && passwordEncoder.matches(request.getPassword(), user.getPassword())) {
                        String token = jwtUtil.generateToken(user.getUsername());
                        return Mono.just(token);
                    } else {
                        return Mono.error(new RuntimeException("Invalid credentials"));
                    }
                });
    }*/
}

