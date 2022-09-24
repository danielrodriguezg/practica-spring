package co.darodriguezg.practicaspring.service;

import co.darodriguezg.practicaspring.domain.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    public User callAuthService(String username, String password) {
        return new User("123", "123", "123", "123");
    }
}
