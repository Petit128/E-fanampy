package mg.efanampy.domain;
import lombok.*;
import java.io.Serializable;
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @EqualsAndHashCode
public class AvisTagId implements Serializable { private Integer idAvis; private String tag; }