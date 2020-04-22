package ad.store.security;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import ad.store.entity.Cliente;
import ad.store.service.UserService;

public class AuthenticationSuccessHandlerImpl implements AuthenticationSuccessHandler{

	@Autowired 
	private UserService userService;
	
	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		
		UserDetails userDetails = (UserDetails)
		SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		HttpSession session = request.getSession();
		Cliente authUser =
		userService.findByUsername(userDetails.getUsername());
		session.setAttribute("username", authUser.getNombreUsuario());
		session.setAttribute("nombre", authUser.getNombre());
		session.setAttribute("idUsuario", authUser.getIdCliente());
		
		boolean isUser = false;
		boolean isAdmin = false;
		final Collection<? extends GrantedAuthority> authorities =
		authentication.getAuthorities();
		for (final GrantedAuthority grantedAuthority : authorities) {
		if (grantedAuthority.getAuthority().equals("ROL_USER")) {
		isUser = true;
		break;
		} else if (grantedAuthority.getAuthority().equals("ROL_ADMIN")) {
		isAdmin = true;
		break;
		}
		}
		String targetUrl;
		if (isUser) {
		targetUrl = "/index";
		} else if (isAdmin) {
		targetUrl = "/index";
		} else {
		throw new IllegalStateException();
		}
		redirectStrategy.sendRedirect(request, response, targetUrl);
		
		
	}

}
