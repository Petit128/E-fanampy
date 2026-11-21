package mg.efanampy.domain;
import jakarta.persistence.*;
import lombok.*;
import java.time.OffsetDateTime;
@Entity @Table(name="signalement_vote")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
@IdClass(SignalementVoteId.class)
public class SignalementVote {
    @Id @Column(name="id_signal") private Integer idSignal;
    @Id @Column(name="id_user") private Integer idUser;
    @Column(name="date_vote", nullable=false) private OffsetDateTime dateVote;
}