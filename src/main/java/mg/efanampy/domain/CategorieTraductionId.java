package mg.efanampy.domain;
import lombok.*;
import java.io.Serializable;
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @EqualsAndHashCode
public class CategorieTraductionId implements Serializable { private Integer idCategorie; private String codeLangue; }