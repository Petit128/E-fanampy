package mg.efanampy.service;
import mg.efanampy.domain.*;
import mg.efanampy.repository.*;
import mg.efanampy.security.JwtService;
import mg.efanampy.web.dto.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.NoSuchElementException;
@Service
public class AuthService {
    private final UtilisateurRepository users; private final RoleRepository roles;
    private final PasswordEncoder enc; private final JwtService jwt;
    public AuthService(UtilisateurRepository u, RoleRepository r, PasswordEncoder e, JwtService j) {
        this.users=u; this.roles=r; this.enc=e; this.jwt=j;
    }
    @Transactional
    public AuthResponse register(RegisterRequest r) {
        if (r.email()==null && r.telephone()==null) throw new IllegalArgumentException("Email ou telephone requis");
        Role role = roles.findByCode("citoyen").orElseThrow();
        Utilisateur u = Utilisateur.builder().email(r.email()).telephone(r.telephone())
            .mdpHash(enc.encode(r.motDePasse())).nomComplet(r.nomComplet())
            .langue(r.langue()==null?"fr":r.langue()).role(role).build();
        users.save(u);
        return new AuthResponse(jwt.generate(u.getIdUser(), role.getCode()), u.getIdUser(), u.getNomComplet(), role.getCode());
    }
    public AuthResponse login(LoginRequest r) {
        Utilisateur u = users.findByEmailOrTelephone(r.email(), r.email())
            .orElseThrow(() -> new NoSuchElementException("Utilisateur inconnu"));
        if (!enc.matches(r.motDePasse(), u.getMdpHash())) throw new IllegalArgumentException("Mot de passe incorrect");
        return new AuthResponse(jwt.generate(u.getIdUser(), u.getRole().getCode()), u.getIdUser(), u.getNomComplet(), u.getRole().getCode());
    }
}