package mg.efanampy.domain;
import jakarta.persistence.*;
import lombok.*;
import java.time.OffsetDateTime;
@Entity @Table(name="contact_confiance")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class ContactConfiance {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Integer idContact;
    @ManyToOne @JoinColumn(name="id_user", nullable=false) private Utilisateur utilisateur;
    @Column(nullable=false) private String nom;
    @Column(nullable=false) private String telephone;
    @Column(name="est_confirme", nullable=false) private Boolean estConfirme;
    @Column(name="date_creation", nullable=false) private OffsetDateTime dateCreation;
}