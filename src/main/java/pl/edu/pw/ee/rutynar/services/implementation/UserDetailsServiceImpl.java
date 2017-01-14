package pl.edu.pw.ee.rutynar.services.implementation;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.edu.pw.ee.rutynar.domain.User;
import pl.edu.pw.ee.rutynar.repositories.UserRepository;

import java.util.Collection;
import java.util.Collections;

/**
 * Created by kiker on 14.01.17.
 */

@Service
public class UserDetailsServiceImpl implements UserDetailsService {


    private final UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository.findByUserName(s).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        Collection<GrantedAuthority> auth = Collections.singleton(new SimpleGrantedAuthority(user.getRole().name()));

        return new org.springframework.security.core.userdetails.User(
                user.getUserName(), user.getPassword(), auth);
    }
}
