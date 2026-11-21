package mg.efanampy.web;
import mg.efanampy.domain.Message;
import mg.efanampy.service.MessageService;
import mg.efanampy.web.dto.MessageRequest;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/demandes/{idDemande}/messages")
public class MessageController {
    private final MessageService svc; public MessageController(MessageService s) { this.svc=s; }
    @GetMapping public List<Message> list(@PathVariable Integer idDemande) { return svc.byDemande(idDemande); }
    @PostMapping public Message send(@PathVariable Integer idDemande, @RequestParam Integer userId, @RequestBody MessageRequest r) {
        return svc.send(idDemande, userId, r);
    }
}