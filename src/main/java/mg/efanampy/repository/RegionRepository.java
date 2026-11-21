package mg.efanampy.repository;
import mg.efanampy.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;
@Repository
public interface RegionRepository extends JpaRepository<Region,Integer>{ Optional<Region> findByNom(String nom); }