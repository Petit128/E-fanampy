package mg.efanampy.service;
import mg.efanampy.domain.*;
import mg.efanampy.repository.*;
import mg.efanampy.web.dto.*;
import org.springframework.stereotype.Service;
import java.time.OffsetDateTime;
import java.util.List;
@Service
public class SosService {
    private final SosAlerteRepository sos; private final UtilisateurRepository users;
    public SosService(SosAlerteRepository s, UtilisateurRepository u) { this.sos=s; this.users=u; }
    public List<SosAlerte> all() { return sos.findAll(); }
    public SosAlerte create(Integer userId, SosRequest r) {
        SosAlerte s = SosAlerte.builder().utilisateur(users.getReferenceById(userId))
            .typeSos(r.typeSos()==null?"autre":r.typeSos())
            .lat(r.lat()).lng(r.lng()).precisionM(r.precisionM())
            .canal(r.canal()==null?"app":r.canal())
            .statutSos("declenchee").niveauReponse(1).build();
        return sos.save(s);
    }
    public SosAlerte confirmer(Integer id) {
        SosAlerte s = sos.findById(id).orElseThrow();
        s.setStatutSos("confirmee"); s.setDateConfirmation(OffsetDateTime.now());
        return s;
    }
}