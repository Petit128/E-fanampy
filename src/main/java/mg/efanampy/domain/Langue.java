package mg.efanampy.domain;
import jakarta.persistence.*;
import lombok.*;
@Entity @Table(name="langue")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Langue {
    @Id @Column(length=35) private String code;
    @Column(nullable=false) private String nom;
    @Column(name="est_active", nullable=false) private Boolean estActive;
}