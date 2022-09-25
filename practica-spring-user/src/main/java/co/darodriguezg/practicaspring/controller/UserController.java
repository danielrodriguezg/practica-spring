package co.darodriguezg.practicaspring.controller;

import co.darodriguezg.practicaspring.domain.entity.User;
import co.darodriguezg.practicaspring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RefreshScope
public class UserController {
    @Value("${configuracion.texto}")
    private String texto;

    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping(path = "/get-user", produces = MediaType.APPLICATION_JSON_VALUE)
    public User getUser(@RequestParam String username, @RequestParam String password){
        return userService.getUser(username, password);
    }

    @GetMapping(path="/read-cloud-config-property", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> readCloudConfigProperty(){
        Map<String, String> json = new HashMap<>();
        json.put("texto", texto);

        return new ResponseEntity<Map<String, String>>(json, HttpStatus.OK);
    }
}
