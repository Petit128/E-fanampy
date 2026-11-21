package mg.efanampy.domain;
import jakarta.persistence.*;
import lombok.*;
import java.time.OffsetDateTime;
@Entity @Table(name="photo")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Photo {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Integer idPhoto;
    @ManyToOne @JoinColumn(name="id_demande", nullable=false) private Demande demande;
    @Column(name="url_photo", nullable=false) private String urlPhoto;
    @Column(name="url_thumb") private String urlThumb;
    @Column(name="taille_ko") private Integer tailleKo;
    @Column(name="type_mime", nullable=false) private String typeMime;
    @Column(name="date_creation", nullable=false) private OffsetDateTime dateCreation;
}