package eu.stiekema.jeroen.vocabtrainer.api.users;

/**
 * @author Jeroen Stiekema
 */
public class UserNotAuthenticatedEvent {
    private UserId userId;

    public UserNotAuthenticatedEvent(UserId userId) {
        this.userId = userId;
    }

    public UserId getUserId() {
        return userId;
    }
}
