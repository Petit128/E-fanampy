package mg.efanampy.domain;
import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
@Entity @Table(name="trace_securite")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class TraceSecurite {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Integer idTrace;
    @ManyToOne @JoinColumn(name="id_user") private Utilisateur utilisateur;
    @Column(name="type_evt", nullable=false) private String typeEvt;
    @Column(name="id_demande") private Integer idDemande;
    @Column(name="id_sos") private Integer idSos;
    @Column(name="id_signal") private Integer idSignal;
    @Column(name="adresse_ip", columnDefinition="inet") private String adresseIp;
    @Column(name="port_source") private Integer portSource;
    @Column(name="id_appareil") private Integer idAppareil;
    @Column(name="empreinte_appareil") private String empreinteAppareil;
    @Column(name="operateur_mobile") private String operateurMobile;
    @Column(name="type_reseau") private String typeReseau;
    @Column(name="user_agent") private String userAgent;
    @Column(name="version_app") private String versionApp;
    private BigDecimal lat;
    private BigDecimal lng;
    @Column(name="precision_m") private Integer precisionM;
    @Column(name="gps_simule") private Boolean gpsSimule;
    @Column(name="date_creation", nullable=false) private OffsetDateTime dateCreation;
    @Column(name="date_purge") private OffsetDateTime datePurge;
}