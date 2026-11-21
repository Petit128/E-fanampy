package mg.efanampy.security;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import mg.efanampy.config.AppProperties;
import org.springframework.stereotype.Service;
import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;
@Service
public class JwtService {
    private final SecretKey key;
    private final long expirationMs;
    public JwtService(AppProperties props) {
        this.key = Keys.hmacShaKeyFor(props.getJwt().getSecret().getBytes(StandardCharsets.UTF_8));
        this.expirationMs = props.getJwt().getExpirationMs();
    }
    public String generate(Integer userId, String role) {
        Date now = new Date();
        return Jwts.builder().subject(String.valueOf(userId)).claim("role", role)
            .issuedAt(now).expiration(new Date(now.getTime() + expirationMs))
            .signWith(key).compact();
    }
    public Claims parse(String t) { return Jwts.parser().verifyWith(key).build().parseSignedClaims(t).getPayload(); }
}