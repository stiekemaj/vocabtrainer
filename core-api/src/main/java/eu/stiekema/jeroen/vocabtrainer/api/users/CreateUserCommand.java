package eu.stiekema.jeroen.vocabtrainer.api.users;

import org.springframework.util.Assert;

/**
 * @author Jeroen Stiekema
 */
public class CreateUserCommand {
    private UserId userId;
    private String username;
    private String name;
    private String password;

    public CreateUserCommand(UserId userId, String username, String name, String password) {
        Assert.notNull(userId);
        Assert.notNull(username);
        Assert.notNull(name);
        Assert.notNull(password);

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
