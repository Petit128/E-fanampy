package mg.efanampy.domain;
import jakarta.persistence.*;
import lombok.*;
import java.time.OffsetDateTime;
@Entity @Table(name="sanction")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Sanction {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Integer idSanction;
    @ManyToOne @JoinColumn(name="id_user", nullable=false) private Utilisateur utilisateur;
    @Column(name="type_sanction", nullable=false) private String typeSanction;
    @Column(nullable=false, columnDefinition="TEXT") private String motif;
    @Column(name="id_demande") private Integer idDemande;
    @Column(name="id_sos") private Integer idSos;
    @Column(name="id_signal") private Integer idSignal;
    @ManyToOne @JoinColumn(name="id_decideur", nullable=false) private Utilisateur decideur;
    @Column(name="points_retires") private Integer pointsRetires;
    @Column(name="date_debut", nullable=false) private OffsetDateTime dateDebut;
    @Column(name="date_fin") private OffsetDateTime dateFin;
    @Column(name="contestation_statut", nullable=false) private String contestationStatut;
    @Column(name="contestation_texte", columnDefinition="TEXT") private String contestationTexte;
    @ManyToOne @JoinColumn(name="id_relecteur") private Utilisateur relecteur;
    @Column(name="date_contestation") private OffsetDateTime dateContestation;
    @Column(name="date_relecture") private OffsetDateTime dateRelecture;
    @Column(name="est_annulee", nullable=false) private Boolean estAnnulee;
    @Column(name="date_creation", nullable=false) private OffsetDateTime dateCreation;
}