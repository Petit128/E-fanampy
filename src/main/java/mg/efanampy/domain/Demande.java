package mg.efanampy.domain;
import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
@Entity @Table(name="demande")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Demande {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Integer idDemande;
    private String reference;
    @ManyToOne @JoinColumn(name="id_user", nullable=false) private Utilisateur utilisateur;
    @ManyToOne @JoinColumn(name="id_categorie", nullable=false) private Categorie categorie;
    @ManyToOne @JoinColumn(name="id_region") private Region region;
    @Column(nullable=false) private String titre;
    @Column(columnDefinition="TEXT") private String description;
    @Column(nullable=false) private String urgence;
    @Column(nullable=false) private String statut;
    @Column(nullable=false) private BigDecimal lat;
    @Column(nullable=false) private BigDecimal lng;
    private String adresse;
    @Column(name="est_publique", nullable=false) private Boolean estPublique;
    @Column(name="cree_hors_ligne", nullable=false) private Boolean creeHorsLigne;
    @Column(name="date_creation_client") private OffsetDateTime dateCreationClient;
    @Column(name="date_sync") private OffsetDateTime dateSync;
    @Column(name="date_creation", nullable=false) private OffsetDateTime dateCreation;
    @Column(name="date_resolution") private OffsetDateTime dateResolution;
    @Column(name="date_maj") private OffsetDateTime dateMaj;
    @PrePersist void prePersist() {
        if (dateCreation == null) dateCreation = OffsetDateTime.now();
        if (estPublique == null) estPublique = false;
        if (creeHorsLigne == null) creeHorsLigne = false;
        if (statut == null) statut = "envoyee";
        if (urgence == null) urgence = "normale";
    }
}