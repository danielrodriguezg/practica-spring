package co.darodriguezg.practicaspring.controller;

import co.darodriguezg.practicaspring.domain.User;
import co.darodriguezg.practicaspring.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.anyString;

@SpringBootTest(classes = UserController.class)
@ContextConfiguration(classes = {UserService.class, UserController.class})
@ExtendWith(SpringExtension.class)
public class UserControllerTest {
    @MockBean
    private UserService userService;

    @Autowired
    private UserController userController;

    @Test
    public void getUser200() throws Exception {
        String username = "daniel";
        String password = "123";
        String uri = "/user";

        Mockito.doReturn(new User()).when(userService).callAuthService(anyString(), anyString());

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get(uri)
                .param("username", username)
                .param("password", password)
                .contentType(MediaType.APPLICATION_JSON);
        MockMvcBuilders.standaloneSetup(this.userController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());

    }
}
