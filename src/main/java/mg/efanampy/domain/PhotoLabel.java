package mg.efanampy.domain;
import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
@Entity @Table(name="photo_label")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class PhotoLabel {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Integer idLabel;
    @ManyToOne @JoinColumn(name="id_photo", nullable=false) private Photo photo;
    @Column(nullable=false) private String label;
    private BigDecimal confiance;
}