package co.darodriguezg.practicaspring.domain;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User implements Serializable {
    private static final long serialVersionUID = 8799656478674716638L;
    private String name;
    private String surname;
    private String username;
    private String lastLogin;

}
