package mjv.spring.jpa.project.seguranca.servico;

import java.util.HashSet;

import javax.transaction.Transactional;

import org.apache.tomcat.jni.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import mjv.spring.jpa.project.adm.dominio.Usuario;
import mjv.spring.jpa.project.adm.dominio.UsuarioRepositorio;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UsuarioRepositorio usuarioRepo;
	
	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepo.findByUsername(username);
		
		Set<GrantedAuthority> authorities = new HashSet<>();
		authorities.add(new SimpleGrantedAuthority(usuario.getRole()));
		
		User userSpring = new User(usuario.getUsername(), usuario.getPassword(), authorities);
		
		return userSpring;
	}
}
