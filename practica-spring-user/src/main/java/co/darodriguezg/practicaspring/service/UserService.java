package co.darodriguezg.practicaspring.service;

import co.darodriguezg.practicaspring.domain.dao.UserDao;
import co.darodriguezg.practicaspringcommons.domain.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserDao userDao;
    @Autowired
    public UserService(UserDao userDao){
        this.userDao = userDao;
    }
    public User getUser(String username, String password) {
        return userDao.findByUsername(username);
    }
}
