//package ro.favasiloaie.airports.service.implementation;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//import ro.favasiloaie.airports.model.User;
//import ro.favasiloaie.airports.repository.UserRepository;
//
//import java.util.HashSet;
//import java.util.Optional;
//import java.util.Set;
//
//@Service
//public class UserServiceImpl implements UserDetailsService {
//
//    private static final String ROLE_PREFIX = "ROLE_";
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Override
//    @Transactional(readOnly = true)
//    public UserDetails loadUserByUsername(final String username) {
//
//        final Optional<User> optionalUser = userRepository.findByEmail(username);
//        final User user = optionalUser.orElseThrow(() -> new UsernameNotFoundException(username));
//
//        final Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
//        grantedAuthorities.add(new SimpleGrantedAuthority(ROLE_PREFIX + user.getRole()));
//
//        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
//                grantedAuthorities);
//    }
//}
