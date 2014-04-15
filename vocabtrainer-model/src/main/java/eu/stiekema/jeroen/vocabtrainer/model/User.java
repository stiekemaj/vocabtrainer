package eu.stiekema.jeroen.vocabtrainer.model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Transient;

/**
 * @author Jeroen Stiekema
 */
@Entity
@Table(name = "USERS")
@TableGenerator(name = "user_seq", table = "serial", pkColumnName = "serial_id",
        pkColumnValue = "users", valueColumnName = "SERIAL_NUMBER")
@NamedQueries({
        @NamedQuery(name = "User.getByEmailAddress",
            query = "select user from User user where user.emailAddress = :emailAddress")
})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "user_seq")
    @Column(name = "USER_ID")
    private Long id;

    private String firstName;

    private String lastName;

    private String emailAddress;

    private String password;

    /*
    @ElementCollection(targetClass = Group.class)
    @CollectionTable(name = "USER_ROLES",
            joinColumns = {
                    @JoinColumn(name = "emailaddress", nullable = false)
            },
            uniqueConstraints = {
                    @UniqueConstraint(columnNames = {"EMAILADDRESS", "ROLENAME"})
            })
    @Column(name = "ROLENAME")
    @Enumerated(EnumType.STRING) */
    @Transient
    private List<Group> groups;

    public User() {
    }

    public Long getId() {
        return id;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
