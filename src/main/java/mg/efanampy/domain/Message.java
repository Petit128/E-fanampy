package mg.efanampy.domain;
import jakarta.persistence.*;
import lombok.*;
import java.time.OffsetDateTime;
@Entity @Table(name="message")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Message {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Integer idMessage;
    @ManyToOne @JoinColumn(name="id_demande", nullable=false) private Demande demande;
    @ManyToOne @JoinColumn(name="id_expediteur", nullable=false) private Utilisateur expediteur;
    @ManyToOne @JoinColumn(name="id_destinataire", nullable=false) private Utilisateur destinataire;
    @Column(nullable=false, columnDefinition="TEXT") private String contenu;
    @Column(name="url_piece_jointe") private String urlPieceJointe;
    @Column(name="est_lu", nullable=false) private Boolean estLu;
    @Column(name="date_lecture") private OffsetDateTime dateLecture;
    @Column(name="date_creation", nullable=false) private OffsetDateTime dateCreation;
}