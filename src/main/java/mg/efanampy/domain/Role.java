package mg.efanampy.domain;
import jakarta.persistence.*;
import lombok.*;
@Entity @Table(name="role")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Role {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Integer idRole;
    @Column(nullable=false, unique=true) private String code;
    @Column(nullable=false) private String libelle;
}