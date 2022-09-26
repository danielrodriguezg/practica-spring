package co.darodriguezg.practicaspringauth.service;

import co.darodriguezg.practicaspringauth.client.UserFeignClient;
import co.darodriguezg.practicaspringcommons.domain.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class UserService implements UserDetailsService {
    private final static Logger LOGGER = LoggerFactory.getLogger(UserService.class);
    private UserFeignClient userFeignClient;
    @Autowired
    public UserService(UserFeignClient userFeignClient){
        this.userFeignClient=userFeignClient;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userFeignClient.findByUsername(username);
        if(user == null){
            LOGGER.error("Error de login, no existe el usuario "+username+" en el sistema.");
            throw new UsernameNotFoundException("Error de login, no existe el usuario "+username+" en el sistema.");
        }
        List<GrantedAuthority> authorities = user.getRoles().stream()
                .map(role -> {
                    return new SimpleGrantedAuthority(role.getName());
                }).peek(authority ->
                        LOGGER.info("Role: "+authority.getAuthority())
                ).collect(Collectors.toList());
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                user.getEnabled(),
                true,
                true,
                true,
                authorities);
    }
}
