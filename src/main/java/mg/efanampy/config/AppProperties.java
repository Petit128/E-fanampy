package mg.efanampy.config;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
@Component
@ConfigurationProperties(prefix = "app")
public class AppProperties {
    private Jwt jwt = new Jwt();
    private String timezone = "Indian/Antananarivo";
    private String deviseDefaut = "MGA";
    private int rayonDefautKm = 10;
    private Matching matching = new Matching();
    public Jwt getJwt() { return jwt; }
    public void setJwt(Jwt jwt) { this.jwt = jwt; }
    public String getTimezone() { return timezone; }
    public void setTimezone(String t) { this.timezone = t; }
    public String getDeviseDefaut() { return deviseDefaut; }
    public void setDeviseDefaut(String d) { this.deviseDefaut = d; }
    public int getRayonDefautKm() { return rayonDefautKm; }
    public void setRayonDefautKm(int r) { this.rayonDefautKm = r; }
    public Matching getMatching() { return matching; }
    public void setMatching(Matching m) { this.matching = m; }
    public static class Jwt { private String secret; private long expirationMs = 86400000L;
        public String getSecret() { return secret; } public void setSecret(String s) { this.secret = s; }
        public long getExpirationMs() { return expirationMs; } public void setExpirationMs(long e) { this.expirationMs = e; } }
    public static class Matching { private double poidsDistance = 0.6; private double poidsNote = 0.4;
        private int noteDefaut = 3; private int limite = 5;
        public double getPoidsDistance() { return poidsDistance; } public void setPoidsDistance(double p) { this.poidsDistance = p; }
        public double getPoidsNote() { return poidsNote; } public void setPoidsNote(double p) { this.poidsNote = p; }
        public int getNoteDefaut() { return noteDefaut; } public void setNoteDefaut(int n) { this.noteDefaut = n; }
        public int getLimite() { return limite; } public void setLimite(int l) { this.limite = l; } }
}