package co.darodriguezg.practicaspringauth.client;

import co.darodriguezg.practicaspringcommons.domain.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="practica-spring-user")
public interface UserFeignClient {
    @GetMapping("/user-hateoas/search/get-username")
    public User findByUsername(@RequestParam String username);
}
