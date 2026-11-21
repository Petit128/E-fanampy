package mg.efanampy.domain;
import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
@Entity @Table(name="assignation")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Assignation {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Integer idAssign;
    @ManyToOne @JoinColumn(name="id_demande", nullable=false) private Demande demande;
    @ManyToOne @JoinColumn(name="id_prest", nullable=false) private Prestataire prestataire;
    @Column(name="statut_assign", nullable=false) private String statutAssign;
    @Column(name="distance_km") private BigDecimal distanceKm;
    @Column(name="eta_min") private Integer etaMin;
    @Column(name="score_match") private BigDecimal scoreMatch;
    @Column(name="date_proposition", nullable=false) private OffsetDateTime dateProposition;
    @Column(name="date_reponse") private OffsetDateTime dateReponse;
    @Column(name="date_debut") private OffsetDateTime dateDebut;
    @Column(name="date_fin") private OffsetDateTime dateFin;
    @Column(name="motif_annulation", columnDefinition="TEXT") private String motifAnnulation;
}