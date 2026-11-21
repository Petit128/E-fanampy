package mg.efanampy.web.dto;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
public record DemandeDto(Integer id, String reference, String titre, String description,
                          String urgence, String statut, String categorieCode,
                          BigDecimal lat, BigDecimal lng, OffsetDateTime dateCreation) {}