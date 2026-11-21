package mg.efanampy.domain;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalTime;
@Entity @Table(name="institution_horaire")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class InstitutionHoraire {
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Integer idHoraire;
    @ManyToOne @JoinColumn(name="id_institution", nullable=false) private Institution institution;
    @Column(name="jour_semaine", nullable=false) private Integer jourSemaine;
    @Column(name="heure_ouverture", nullable=false) private LocalTime heureOuverture;
    @Column(name="heure_fermeture", nullable=false) private LocalTime heureFermeture;
}