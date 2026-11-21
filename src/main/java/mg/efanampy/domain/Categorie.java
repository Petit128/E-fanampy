package mg.efanampy.domain;
import jakarta.persistence.*;
import lombok.*;
@Entity @Table(name="categorie")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Categorie {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Integer idCategorie;
    @Column(name="code_cat", nullable=false, unique=true) private String codeCat;
    @Column(nullable=false) private String portee;
    @Column(name="nom_icone") private String nomIcone;
    @Column(length=7) private String couleur;
    @ManyToOne @JoinColumn(name="parent_id") private Categorie parent;
    @Column(name="est_active", nullable=false) private Boolean estActive;
}