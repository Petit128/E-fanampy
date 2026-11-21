package mg.efanampy.domain;
import jakarta.persistence.*;
import lombok.*;
import java.time.OffsetDateTime;
@Entity @Table(name="avis")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Avis {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Integer idAvis;
    @ManyToOne @JoinColumn(name="id_demande", nullable=false) private Demande demande;
    @ManyToOne @JoinColumn(name="id_auteur", nullable=false) private Utilisateur auteur;
    @ManyToOne @JoinColumn(name="id_cible", nullable=false) private Utilisateur cible;
    @Column(nullable=false) private Integer note;
    @Column(columnDefinition="TEXT") private String commentaire;
    @Column(name="date_creation", nullable=false) private OffsetDateTime dateCreation;
}