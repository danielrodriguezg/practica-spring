package co.darodriguezg.practicaspring.service;

import co.darodriguezg.practicaspring.domain.entity.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    public User getUser(String username, String password) {
        return new User();
    }
}
