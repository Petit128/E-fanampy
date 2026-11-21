package mg.efanampy.domain;
import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.*;
@Entity @Table(name="prestataire")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Prestataire {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Integer idPrest;
    @OneToOne @JoinColumn(name="id_user", nullable=false, unique=true) private Utilisateur utilisateur;
    @Column(name="nom_entreprise") private String nomEntreprise;
    @Column(columnDefinition="TEXT") private String bio;
    @Column(name="annees_exp") private Integer anneesExp;
    @Column(name="tarif_horaire") private BigDecimal tarifHoraire;
    @Column(length=3) private String devise;
    @Column(name="est_disponible", nullable=false) private Boolean estDisponible;
    @Column(name="lat_actuelle") private BigDecimal latActuelle;
    @Column(name="lng_actuelle") private BigDecimal lngActuelle;
    @Column(name="rayon_intervention", nullable=false) private Integer rayonIntervention;
    @Column(name="date_verification") private LocalDate dateVerification;
    @Column(name="url_kyc") private String urlKyc;
    @Column(name="date_maj") private OffsetDateTime dateMaj;
}