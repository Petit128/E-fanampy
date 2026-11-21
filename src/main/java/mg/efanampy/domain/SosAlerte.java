package mg.efanampy.domain;
import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
@Entity @Table(name="sos_alerte")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class SosAlerte {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Integer idSos;
    private String reference;
    @ManyToOne @JoinColumn(name="id_user", nullable=false) private Utilisateur utilisateur;
    @Column(name="type_sos", nullable=false) private String typeSos;
    @Column(nullable=false) private BigDecimal lat;
    @Column(nullable=false) private BigDecimal lng;
    @Column(name="precision_m") private Integer precisionM;
    @Column(name="statut_sos", nullable=false) private String statutSos;
    @Column(nullable=false) private String canal;
    @Column(name="mode_confirmation") private String modeConfirmation;
    @Column(name="score_credibilite") private Integer scoreCredibilite;
    @Column(name="niveau_reponse", nullable=false) private Integer niveauReponse;
    @ManyToOne @JoinColumn(name="id_operateur") private Utilisateur operateur;
    @Column(name="cree_hors_ligne", nullable=false) private Boolean creeHorsLigne;
    @Column(name="date_creation_client") private OffsetDateTime dateCreationClient;
    @Column(name="date_creation", nullable=false) private OffsetDateTime dateCreation;
    @Column(name="date_confirmation") private OffsetDateTime dateConfirmation;
    @Column(name="date_cloture") private OffsetDateTime dateCloture;
    @Column(name="motif_cloture", columnDefinition="TEXT") private String motifCloture;
    @PrePersist void prePersist() {
        if (dateCreation == null) dateCreation = OffsetDateTime.now();
        if (creeHorsLigne == null) creeHorsLigne = false;
        if (niveauReponse == null) niveauReponse = 1;
        if (canal == null) canal = "app";
        if (statutSos == null) statutSos = "declenchee";
        if (typeSos == null) typeSos = "autre";
    }
}