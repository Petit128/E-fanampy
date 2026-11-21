package mg.efanampy.domain;
import lombok.*;
import java.io.Serializable;
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @EqualsAndHashCode
public class SignalementVoteId implements Serializable { private Integer idSignal; private Integer idUser; }