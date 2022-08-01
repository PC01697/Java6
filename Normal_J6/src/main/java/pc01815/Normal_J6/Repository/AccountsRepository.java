package pc01815.Normal_J6.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pc01815.Normal_J6.Entity.Accounts;

public interface AccountsRepository extends JpaRepository<Accounts, Integer>{
	@Query("SELECT o FROM Accounts o WHERE username=?1")
	Accounts findByUsername(String username);
}
