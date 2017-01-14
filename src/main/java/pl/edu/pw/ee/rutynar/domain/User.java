package pl.edu.pw.ee.rutynar.domain;

import javax.persistence.*;

/**
 * Created by kiker on 14.01.17.
 */

@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @Column(unique = true, nullable = false)
    private String userName;

    @Column( nullable = false)
    private String password;
}
