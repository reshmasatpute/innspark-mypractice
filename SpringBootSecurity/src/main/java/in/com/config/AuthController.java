package in.com.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	private JwtUtil util;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserDetailsService userDetailsService; // Inject your 
	
	@PostMapping("/register")
	public String addUser(@RequestBody Users user) {
		return util.saveUser(user);
	}

	@PostMapping("/token")
	public String getToken(@RequestBody AuthRequest authRequest) {
		System.err.println("-->1");
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
		if (authentication.isAuthenticated()) {
			return util.generateToken(authRequest.getUsername());

		} else {
			throw new RuntimeException("invalid access......");
		}

	}
	
	@GetMapping("/welcome")
	public String welcome() {
		return "Welcome to the user details";
	}

	@GetMapping("/validate")
	public String validateToken(@RequestParam("token") String token ) {
	    String username = util.extractUsername(token); // Extract username from token
		UserDetails userDetails = userDetailsService.loadUserByUsername(username);
		if (userDetails == null) {
	        throw new UsernameNotFoundException("User not found with username: " + username);
	    }

	    if (util.validateToken(token, userDetails)) {
	        return "Token is valid.";
	    } else {
	        return "Token is invalid or expired.";
	    }
	}

}
