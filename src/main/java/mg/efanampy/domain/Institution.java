package mg.efanampy.domain;
import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
@Entity @Table(name="institution")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Institution {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Integer idInstitution;
    @OneToOne @JoinColumn(name="id_user", nullable=false, unique=true) private Utilisateur utilisateur;
    @Column(name="nom_inst", nullable=false) private String nomInst;
    @Column(name="type_inst", nullable=false) private String typeInst;
    @ManyToOne @JoinColumn(name="id_region") private Region region;
    private String adresse;
    private BigDecimal lat;
    private BigDecimal lng;
    @Column(name="est_actif", nullable=false) private Boolean estActif;
}