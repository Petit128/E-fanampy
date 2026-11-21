package mg.efanampy.domain;
import jakarta.persistence.*;
import lombok.*;
@Entity @Table(name="categorie_traduction")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
@IdClass(CategorieTraductionId.class)
public class CategorieTraduction {
    @Id @Column(name="id_categorie") private Integer idCategorie;
    @Id @Column(name="code_langue", length=35) private String codeLangue;
    @Column(nullable=false) private String libelle;
}