package pc01815.Normal_J6.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pc01815.Normal_J6.Entity.Accounts;

public interface AccountsRepository extends JpaRepository<Accounts, Integer>{
//	@Query("SELECT o FROM Accounts o WHERE username=?1")
	Accounts findByUsername(String username);
	
	Accounts findByEmail(String email);
	@Query(value = "select count(id) from accounts where username LIKE :username", nativeQuery = true)
	int IsExitAccount(@Param("username") String username);
}
