package mg.efanampy.domain;
import jakarta.persistence.*;
import lombok.*;
import java.time.OffsetDateTime;
@Entity @Table(name="ticket_acces")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class TicketAcces {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Integer idTicket;
    @ManyToOne @JoinColumn(name="id_dossier", nullable=false) private DossierAbus dossier;
    @ManyToOne @JoinColumn(name="id_demandeur", nullable=false) private Utilisateur demandeur;
    @Column(nullable=false) private String portee;
    @Column(nullable=false, columnDefinition="TEXT") private String motif;
    @Column(nullable=false) private String statut;
    @ManyToOne @JoinColumn(name="id_admin") private Utilisateur admin;
    @Column(name="date_decision") private OffsetDateTime dateDecision;
    @Column(name="motif_decision", columnDefinition="TEXT") private String motifDecision;
    @Column(name="date_expiration") private OffsetDateTime dateExpiration;
    @Column(name="date_creation", nullable=false) private OffsetDateTime dateCreation;
}