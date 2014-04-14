package eu.stiekema.jeroen.vocabtrainer.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

/**
 * @author Jeroen Stiekema
 */
@Entity
@Table(name = "USERS")
@TableGenerator(name = "user_seq", table = "serial", pkColumnName = "serial_id",
        pkColumnValue = "user", valueColumnName = "serial_value")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "user_seq")
    @Column(name = "USER_ID")
    private Long id;

    private String firstName;

    private String lastName;

    public User() {
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
