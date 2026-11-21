package mg.efanampy.domain;
import jakarta.persistence.*;
import lombok.*;
import java.time.OffsetDateTime;
@Entity @Table(name="dossier_abus")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class DossierAbus {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Integer idDossier;
    private String reference;
    @ManyToOne @JoinColumn(name="id_victime", nullable=false) private Utilisateur victime;
    @Column(name="type_victime", nullable=false) private String typeVictime;
    @Column(name="id_demande") private Integer idDemande;
    @Column(name="id_sos") private Integer idSos;
    @Column(name="id_signal") private Integer idSignal;
    @ManyToOne @JoinColumn(name="id_auteur_presume") private Utilisateur auteurPresume;
    @Column(columnDefinition="TEXT") private String description;
    @Column(nullable=false) private String statut;
    @Column(name="niveau_divulgation", nullable=false) private String niveauDivulgation;
    @Column(name="pseudonyme_auteur") private String pseudonymeAuteur;
    @Column(name="reference_autorites") private String referenceAutorites;
    @Column(name="date_transmission_autorites") private OffsetDateTime dateTransmissionAutorites;
    @ManyToOne @JoinColumn(name="id_traitant") private Utilisateur traitant;
    @Column(name="date_creation", nullable=false) private OffsetDateTime dateCreation;
    @Column(name="date_cloture") private OffsetDateTime dateCloture;
}