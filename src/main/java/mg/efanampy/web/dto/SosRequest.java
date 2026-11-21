package mg.efanampy.web.dto;
import java.math.BigDecimal;
public record SosRequest(String typeSos, BigDecimal lat, BigDecimal lng, Integer precisionM, String canal) {}