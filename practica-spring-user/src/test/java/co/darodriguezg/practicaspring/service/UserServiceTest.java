package co.darodriguezg.practicaspring.service;

import co.darodriguezg.practicaspring.AppConfig;
import co.darodriguezg.practicaspring.domain.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.bind.annotation.RestController;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {RestController.class, AppConfig.class, UserService.class})
public class UserServiceTest {
    @Autowired
    private UserService userService;
    @Test
    public void callAuthService(){
        String username = "daniel";
        String password = "123";
        User user = userService.callAuthService(username, password);
        assertEquals(user.getName(), "123");
    }
}
