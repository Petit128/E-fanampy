package mg.efanampy.domain;
import jakarta.persistence.*;
import lombok.*;
import java.time.OffsetDateTime;
import java.util.UUID;
@Entity @Table(name="utilisateur")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Utilisateur {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Integer idUser;
    private String email;
    private String telephone;
    @Column(name="mdp_hash", nullable=false) private String mdpHash;
    @Column(name="nom_complet", nullable=false) private String nomComplet;
    @Column(name="avatar_url") private String avatarUrl;
    @ManyToOne(fetch=FetchType.EAGER) @JoinColumn(name="id_role", nullable=false) private Role role;
    @Column(nullable=false, length=35) private String langue;
    @Column(name="est_actif", nullable=false) private Boolean estActif;
    @Column(name="est_verifie", nullable=false) private Boolean estVerifie;
    @Column(name="score_confiance", nullable=false) private Integer scoreConfiance;
    @Column(name="pin_sos_hash") private String pinSosHash;
    @Column(name="pin_contrainte_hash") private String pinContrainteHash;
    @Column(name="date_creation", nullable=false) private OffsetDateTime dateCreation;
    @Column(name="date_maj") private OffsetDateTime dateMaj;
    @Column(name="date_suppr") private OffsetDateTime dateSuppr;
    @PrePersist void prePersist() {
        if (dateCreation == null) dateCreation = OffsetDateTime.now();
        if (langue == null) langue = "fr";
        if (estActif == null) estActif = true;
        if (estVerifie == null) estVerifie = false;
        if (scoreConfiance == null) scoreConfiance = 50;
    }
}