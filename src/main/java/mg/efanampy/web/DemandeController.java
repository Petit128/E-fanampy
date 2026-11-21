package mg.efanampy.web;
import mg.efanampy.service.DemandeService;
import mg.efanampy.web.dto.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/demandes")
public class DemandeController {
    private final DemandeService svc; public DemandeController(DemandeService s) { this.svc=s; }
    @GetMapping public List<DemandeDto> list() { return svc.list(); }
    @PostMapping public ResponseEntity<DemandeDto> create(@RequestParam Integer userId, @RequestBody DemandeCreateRequest r) {
        return ResponseEntity.ok(svc.create(userId, r));
    }
    @PostMapping("/{id}/suivi")
    public ResponseEntity<DemandeDto> suivi(@PathVariable Integer id, @RequestParam Integer userId, @RequestBody SuiviRequest r) {
        return ResponseEntity.ok(svc.changeStatut(id, userId, r));
    }
}