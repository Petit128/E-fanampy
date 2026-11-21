package mg.efanampy.domain;
import jakarta.persistence.*;
import lombok.*;
import java.time.OffsetDateTime;
@Entity @Table(name="journal_acces_sensible")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class JournalAccesSensible {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Integer idAcces;
    @ManyToOne @JoinColumn(name="id_agent", nullable=false) private Utilisateur agent;
    @ManyToOne @JoinColumn(name="id_dossier", nullable=false) private DossierAbus dossier;
    @ManyToOne @JoinColumn(name="id_ticket", nullable=false) private TicketAcces ticket;
    @Column(name="id_trace") private Integer idTrace;
    @Column(nullable=false) private String action;
    @Column(nullable=false, columnDefinition="TEXT") private String motif;
    @Column(name="date_creation", nullable=false) private OffsetDateTime dateCreation;
}