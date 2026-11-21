package mg.efanampy.web;
import mg.efanampy.service.AuthService;
import mg.efanampy.web.dto.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthService svc; public AuthController(AuthService s) { this.svc=s; }
    @PostMapping("/register") public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest r) { return ResponseEntity.ok(svc.register(r)); }
    @PostMapping("/login") public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest r) { return ResponseEntity.ok(svc.login(r)); }
}