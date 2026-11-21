package mg.efanampy.domain;
import jakarta.persistence.*;
import lombok.*;
@Entity @Table(name="region")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Region {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Integer idRegion;
    @Column(nullable=false, unique=true) private String nom;
}