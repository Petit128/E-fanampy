package mg.efanampy.domain;
import jakarta.persistence.*;
import lombok.*;
@Entity @Table(name="prestataire_categorie")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
@IdClass(PrestataireCategorieId.class)
public class PrestataireCategorie {
    @Id @Column(name="id_prest") private Integer idPrest;
    @Id @Column(name="id_categorie") private Integer idCategorie;
}