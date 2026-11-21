package mg.efanampy.web.dto;
public record AuthResponse(String token, Integer idUser, String nomComplet, String role) {}