package ad.store.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ad.store.dao.UserDao;
import ad.store.entity.Cliente;
import ad.store.entity.Rol;


@Transactional
@Service
public class CustomUserDetailsService implements  UserDetailsService {

	@Autowired
	private UserDao userDao;
	
	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

		Cliente cliente = userDao.findByUsername(userName);
		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
		for (Rol rol : cliente.getRoles()) {
			grantedAuthorities.add(new SimpleGrantedAuthority(rol.getNombreRol()));
			System.out.println(rol.getNombreRol());
		}

		return new org.springframework.security.core.userdetails.User(cliente.getNombreUsuario(), cliente.getPassword(),
				grantedAuthorities);
	}
}
