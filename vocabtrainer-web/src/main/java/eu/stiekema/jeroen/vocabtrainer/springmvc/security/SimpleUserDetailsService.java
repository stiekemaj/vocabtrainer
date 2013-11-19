package eu.stiekema.jeroen.vocabtrainer.springmvc.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author Jeroen Stiekema
 */
public class SimpleUserDetailsService implements UserDetailsService {
    private Map<String, UserDetails> userDetailsMap;

    private PasswordEncoder passwordEncoder;

    public SimpleUserDetailsService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;

        userDetailsMap = new HashMap<String, UserDetails>();
        userDetailsMap.put("bob", new User("bob", "$2a$12$o1KslOVlRjE89dlL42C/3uIxKeK2QRq70uIVvfr7O.T8SVByNywu6", getStandardAuthorities())); // password = bob123
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (!userDetailsMap.containsKey(username)) {
            throw new UsernameNotFoundException(String.format("Username '%s' not found", username));
        }

        return userDetailsMap.get(username);
    }

    public void addUser(String username, String password, Set<GrantedAuthority> authorities) {
        User user = new User(username, passwordEncoder.encode(password), authorities);
        userDetailsMap.put(username, user);
    }

    public void addUser(String username, String password) {
        User user = new User(username, passwordEncoder.encode(password), getStandardAuthorities());
        userDetailsMap.put(username, user);
    }

    public Collection<? extends GrantedAuthority> getStandardAuthorities() {
        Collection<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        return grantedAuthorities;
    }
}
