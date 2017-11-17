package me.aruna.week6challange;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Transactional
@Service
public class SSUserDetailsService implements UserDetailsService {
    private UserDataRepository userRepository;

    public SSUserDetailsService(UserDataRepository userDataRepository){
        this.userRepository=userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try{
            UserData user = userRepository.findByUsername(username);
            if(user==null)
            {
                return null;
            }

            return new org.springframework.security.core.userdetails.User(user.getUserName(),user.getPassword(),getAuthorities(user));

        }catch (Exception e)
        {

        }
        return null;
    }

    private Set<GrantedAuthority> getAuthorities(UserData user) {
        Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
        for(UserRole eachRole:user.getRoles())
        {
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(eachRole.getRole());
            authorities.add(grantedAuthority);
        }
        return authorities;
    }
}
