package mg.efanampy.domain;
import lombok.*;
import java.io.Serializable;
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @EqualsAndHashCode
public class PrestataireCategorieId implements Serializable { private Integer idPrest; private Integer idCategorie; }