package mg.efanampy.domain;
import jakarta.persistence.*;
import lombok.*;
@Entity @Table(name="avis_tag")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
@IdClass(AvisTagId.class)
public class AvisTag {
    @Id @Column(name="id_avis") private Integer idAvis;
    @Id private String tag;
}