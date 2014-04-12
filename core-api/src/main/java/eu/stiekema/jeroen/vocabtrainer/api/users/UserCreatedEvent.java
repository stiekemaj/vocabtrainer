package eu.stiekema.jeroen.vocabtrainer.api.users;

/**
 * @author Jeroen Stiekema
 */
public class UserCreatedEvent {
    private UserId userId;
    private String username;
    private String name;
    private String password;

    public UserCreatedEvent(UserId userId, String username, String name, String password) {
        this.userId = userId;
        this.username = username;
        this.name = name;
        this.password = password;
    }

    public UserId getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
}
