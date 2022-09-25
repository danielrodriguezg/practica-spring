package co.darodriguezg.practicaspring.domain.dao;

import co.darodriguezg.practicaspring.domain.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserDao extends PagingAndSortingRepository<User, Long> {
    public User findByUsername(String username);

    @Query("select u from User u where u.username=?1")
    public User findByUsername1(String username);

    @Query(value = "SELECT * FROM app_user WHERE username = ?1", nativeQuery = true)
    public User findByUsername2(String username);
}
