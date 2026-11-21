package mg.efanampy.domain;
import jakarta.persistence.*;
import lombok.*;
@Entity @Table(name="statut_demande")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class StatutDemande {
    @Id @Column(length=255) private String code;
    @Column(nullable=false) private String libelle;
    @Column(name="est_final", nullable=false) private Boolean estFinal;
}