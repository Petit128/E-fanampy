package mg.efanampy.domain;
import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
@Entity @Table(name="signalement")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Signalement {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Integer idSignal;
    private String reference;
    @ManyToOne @JoinColumn(name="id_user", nullable=false) private Utilisateur utilisateur;
    @ManyToOne @JoinColumn(name="id_institution") private Institution institution;
    @ManyToOne @JoinColumn(name="id_categorie", nullable=false) private Categorie categorie;
    @ManyToOne @JoinColumn(name="id_region") private Region region;
    @Column(nullable=false) private String titre;
    @Column(columnDefinition="TEXT") private String description;
    @Column(nullable=false) private BigDecimal lat;
    @Column(nullable=false) private BigDecimal lng;
    private String adresse;
    @Column(name="url_photo") private String urlPhoto;
    @Column(nullable=false) private String statut;
    @Column(nullable=false) private String priorite;
    @ManyToOne @JoinColumn(name="assigned_to") private Utilisateur assignedTo;
    @Column(name="date_resolution") private OffsetDateTime dateResolution;
    @Column(name="date_creation", nullable=false) private OffsetDateTime dateCreation;
    @Column(name="date_maj") private OffsetDateTime dateMaj;
}