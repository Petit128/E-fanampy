package mg.efanampy.service;
import mg.efanampy.domain.*;
import mg.efanampy.repository.*;
import mg.efanampy.web.dto.*;
import org.springframework.stereotype.Service;
import java.time.OffsetDateTime;
import java.util.List;
@Service
public class MessageService {
    private final MessageRepository msgs; private final DemandeRepository demandes; private final UtilisateurRepository users;
    public MessageService(MessageRepository m, DemandeRepository d, UtilisateurRepository u) { this.msgs=m; this.demandes=d; this.users=u; }
    public List<Message> byDemande(Integer id) { return msgs.findByDemandeIdDemandeOrderByDateCreationAsc(id); }
    public Message send(Integer idDemande, Integer idExp, MessageRequest r) {
        return msgs.save(Message.builder().demande(demandes.getReferenceById(idDemande))
            .expediteur(users.getReferenceById(idExp)).destinataire(users.getReferenceById(r.destinataireId()))
            .contenu(r.contenu()).estLu(false).dateCreation(OffsetDateTime.now()).build());
    }
}