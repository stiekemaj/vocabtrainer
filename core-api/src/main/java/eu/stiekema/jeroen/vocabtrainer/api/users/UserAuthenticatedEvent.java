package eu.stiekema.jeroen.vocabtrainer.api.users;

/**
 * @author Jeroen Stiekema
 */
public class UserAuthenticatedEvent {
    private UserId userId;

    public UserAuthenticatedEvent(UserId userId) {
        this.userId = userId;
    }

    public UserId getUserId() {
        return userId;
    }
}
