package ad.store.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component("rolRepository")
public interface RolRepository extends JpaRepository<Rol, Integer>{
	

}
