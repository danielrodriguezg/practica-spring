package co.darodriguezg.practicaspring.domain.dao;

import co.darodriguezg.practicaspringcommons.domain.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(path="user-hateoas")
public interface UserDao extends PagingAndSortingRepository<User, Long> {
    @RestResource(path="get-username")
    public User findByUsername(@Param("username") String username);

    @Query("select u from User u where u.username=?1")
    public User findByUsername1(String username);

    @Query(value = "SELECT * FROM app_user WHERE username = ?1", nativeQuery = true)
    public User findByUsername2(String username);
}
