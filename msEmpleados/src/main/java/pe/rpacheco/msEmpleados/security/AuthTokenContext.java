package pe.rpacheco.msEmpleados.security;

public class AuthTokenContext {
	
	private static String token;

	public static String getToken() {
		return token;
	}

	public static void setToken(String _token) {
		token = _token;
	}

}
