package mg.efanampy.domain;
import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
@Entity @Table(name="suivi_statut")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class SuiviStatut {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Integer idSuivi;
    @ManyToOne @JoinColumn(name="id_demande", nullable=false) private Demande demande;
    @ManyToOne @JoinColumn(name="id_user", nullable=false) private Utilisateur utilisateur;
    @Column(nullable=false) private String statut;
    @Column(name="note_suivi", columnDefinition="TEXT") private String noteSuivi;
    private BigDecimal lat;
    private BigDecimal lng;
    @Column(name="date_creation", nullable=false) private OffsetDateTime dateCreation;
}