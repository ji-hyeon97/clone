package eatda.clone.model;


import lombok.Getter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Table(name = "USERS", uniqueConstraints = {@UniqueConstraint(columnNames = "email")})
@Getter
@Entity
public class User {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;
}
