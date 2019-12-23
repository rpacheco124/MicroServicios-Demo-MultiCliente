package pe.rpacheco.msSeguridad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

public class ApplicationGetPassword {

	@Autowired
	static PasswordEncoder passwordEncoder;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(passwordEncoder.encode("Password"));
	}

}
