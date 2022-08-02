package pc01815.Normal_J6;

import java.util.Random;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class test {
	
	public static String generateRandomPassword(int len) {
		String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijk"
          +"lmnopqrstuvwxyz!@#$%&";
		Random rnd = new Random();
		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len; i++)
			sb.append(chars.charAt(rnd.nextInt(chars.length())));
		return sb.toString();
	}
	public static void main(String[] args) {
//		test t = new test();
//		t.generateRandomPassword(10);
//		System.err.println(t.generateRandomPassword(10));
		BCryptPasswordEncoder endcoder = new BCryptPasswordEncoder();
		System.err.println(endcoder.encode("123"));
	}
}
