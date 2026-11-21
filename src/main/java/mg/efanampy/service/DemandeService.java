package mg.efanampy.service;
import mg.efanampy.domain.*;
import mg.efanampy.repository.*;
import mg.efanampy.web.dto.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.OffsetDateTime;
import java.util.*;
@Service
public class DemandeService {
    private final DemandeRepository demandes; private final UtilisateurRepository users;
    private final CategorieRepository cats; private final RegionRepository regions;
    private final SuiviStatutRepository suivis;
    public DemandeService(DemandeRepository d, UtilisateurRepository u, CategorieRepository c,
                          RegionRepository r, SuiviStatutRepository s) {
        this.demandes=d; this.users=u; this.cats=c; this.regions=r; this.suivis=s;
    }
    @Transactional
    public DemandeDto create(Integer userId, DemandeCreateRequest r) {
        Utilisateur u = users.findById(userId).orElseThrow();
        Categorie c = cats.findByCodeCat(r.categorieCode()).orElseThrow();
        Region reg = r.idRegion()==null?null:regions.findById(r.idRegion()).orElse(null);
        Demande d = Demande.builder().utilisateur(u).categorie(c).region(reg)
            .titre(r.titre()).description(r.description())
            .urgence(r.urgence()==null?"normale":r.urgence())
            .lat(r.lat()).lng(r.lng()).adresse(r.adresse()).build();
        demandes.save(d);
        return toDto(d);
    }
    public List<DemandeDto> list() { return demandes.findAll().stream().map(this::toDto).toList(); }
    @Transactional
    public DemandeDto changeStatut(Integer id, Integer userId, SuiviRequest r) {
        Demande d = demandes.findById(id).orElseThrow();
        suivis.save(SuiviStatut.builder().demande(d).utilisateur(users.getReferenceById(userId))
            .statut(r.statut()).noteSuivi(r.note()).dateCreation(OffsetDateTime.now()).build());
        d.setStatut(r.statut());
        return toDto(d);
    }
    private DemandeDto toDto(Demande d) {
        return new DemandeDto(d.getIdDemande(), d.getReference(), d.getTitre(), d.getDescription(),
            d.getUrgence(), d.getStatut(), d.getCategorie().getCodeCat(),
            d.getLat(), d.getLng(), d.getDateCreation());
    }
}