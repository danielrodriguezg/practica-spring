package co.darodriguezg.practicaspring.controller;

import co.darodriguezg.practicaspring.domain.User;
import co.darodriguezg.practicaspring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping(path = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
    public User getUser(@RequestParam String username, @RequestParam String password){
        return userService.callAuthService(username, password);
    }
}
