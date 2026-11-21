package mg.efanampy.web.dto;
import java.math.BigDecimal;
public record DemandeCreateRequest(String titre, String description, String urgence,
                                    String categorieCode, BigDecimal lat, BigDecimal lng,
                                    String adresse, Integer idRegion) {}