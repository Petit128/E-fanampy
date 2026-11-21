package mg.efanampy.domain;
import jakarta.persistence.*;
import lombok.*;
import java.time.OffsetDateTime;
@Entity @Table(name="notification")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Notification {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Integer idNotif;
    @ManyToOne @JoinColumn(name="id_user", nullable=false) private Utilisateur utilisateur;
    @Column(name="type_notif", nullable=false) private String typeNotif;
    @Column(name="titre_notif", nullable=false) private String titreNotif;
    @Column(name="corps_notif", columnDefinition="TEXT") private String corpsNotif;
    @Column(columnDefinition="jsonb") private String donnees;
    @Column(name="est_lu", nullable=false) private Boolean estLu;
    @Column(name="date_lecture") private OffsetDateTime dateLecture;
    @Column(name="date_creation", nullable=false) private OffsetDateTime dateCreation;
}