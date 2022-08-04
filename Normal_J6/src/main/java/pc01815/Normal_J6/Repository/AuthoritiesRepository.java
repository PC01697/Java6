package pc01815.Normal_J6.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pc01815.Normal_J6.Entity.Accounts;
import pc01815.Normal_J6.Entity.Authorities;

public interface AuthoritiesRepository extends JpaRepository<Authorities, Integer>{

	
}
