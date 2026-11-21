package mg.efanampy.domain;
import jakarta.persistence.*;
import lombok.*;
import java.time.OffsetDateTime;
@Entity @Table(name="appareil")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Appareil {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Integer idAppareil;
    @ManyToOne @JoinColumn(name="id_user", nullable=false) private Utilisateur utilisateur;
    @Column(name="fcm_token") private String fcmToken;
    private String plateforme;
    @Column(name="empreinte_hash") private String empreinteHash;
    @Column(name="cle_publique", columnDefinition="TEXT") private String clePublique;
    @Column(name="est_de_confiance", nullable=false) private Boolean estDeConfiance;
    @Column(name="date_derniere_utilisation") private OffsetDateTime dateDerniereUtilisation;
    @Column(name="date_creation", nullable=false) private OffsetDateTime dateCreation;
}