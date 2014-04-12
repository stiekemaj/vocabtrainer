package eu.stiekema.jeroen.vocabtrainer.api.users;

/**
 * @author Jeroen Stiekema
 */
public class AuthenticateUserCommand {
    private String username;
    private String password;

    public AuthenticateUserCommand(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
