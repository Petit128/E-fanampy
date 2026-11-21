package mg.efanampy.repository;
import mg.efanampy.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;
@Repository
public interface MessageRepository extends JpaRepository<Message,Integer>{ List<Message> findByDemandeIdDemandeOrderByDateCreationAsc(Integer id); }