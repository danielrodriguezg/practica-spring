package co.darodriguezg.practicaspring.domain.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "app_user")
public class User implements Serializable {
    private static final long serialVersionUID = 8799656478674716638L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, length = 20)
    private String username;
    @Column(length = 60)
    private String password;
    private Boolean enabled;
    private String name;
    private String surname;
    @Column(unique = true, length = 100)
    private String email;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name="app_user_roles"
            , joinColumns = @JoinColumn(name="app_user_id")
            , inverseJoinColumns = @JoinColumn(name="role_id")
            , uniqueConstraints = {@UniqueConstraint(columnNames = {"app_user_id", "role_id"})}
    )
    private List<Role> roles;
}
