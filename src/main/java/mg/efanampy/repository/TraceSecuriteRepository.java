package mg.efanampy.repository;
import mg.efanampy.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;
@Repository
public interface TraceSecuriteRepository extends JpaRepository<TraceSecurite,Integer>{}