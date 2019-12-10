package pe.rpacheco.msSeguridad.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import pe.rpacheco.msSeguridad.entity.Usuario;
import pe.rpacheco.msSeguridad.repository.UsuarioRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("Init Auth [" + username + "]");
		Usuario usuario = usuarioRepository.findByUsuario(username);
		if (usuario == null) {
			throw new UsernameNotFoundException("UserName " + username + " not found");
		}
		return new CustomUserDetails(usuario);
	}


}
