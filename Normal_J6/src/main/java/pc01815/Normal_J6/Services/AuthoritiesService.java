package pc01815.Normal_J6.Services;

import java.util.List;

import pc01815.Normal_J6.Entity.Accounts;
import pc01815.Normal_J6.Entity.Authorities;

public interface AuthoritiesService {

	 Authorities authService(int id);
	 void delete(Authorities id);
	
	 Authorities saveAuthoritiesService(Authorities authorities);
}
