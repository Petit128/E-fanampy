package mg.efanampy.repository;
import mg.efanampy.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;
@Repository
public interface SuiviStatutRepository extends JpaRepository<SuiviStatut,Integer>{ List<SuiviStatut> findByDemandeIdDemandeOrderByDateCreationAsc(Integer id); }