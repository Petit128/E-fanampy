package mg.efanampy.web;
import mg.efanampy.domain.SosAlerte;
import mg.efanampy.service.SosService;
import mg.efanampy.web.dto.SosRequest;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/sos")
public class SosController {
    private final SosService svc; public SosController(SosService s) { this.svc=s; }
    @GetMapping public List<SosAlerte> all() { return svc.all(); }
    @PostMapping public SosAlerte create(@RequestParam Integer userId, @RequestBody SosRequest r) { return svc.create(userId, r); }
    @PatchMapping("/{id}/confirmer") public SosAlerte confirmer(@PathVariable Integer id) { return svc.confirmer(id); }
}