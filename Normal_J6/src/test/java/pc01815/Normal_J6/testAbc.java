package pc01815.Normal_J6;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class testAbc {
	public static void main(String[] args) {
		
		BCryptPasswordEncoder endcode = new BCryptPasswordEncoder();
		System.err.println(endcode.encode("test"));
	}
}
