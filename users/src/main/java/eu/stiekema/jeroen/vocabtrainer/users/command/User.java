package eu.stiekema.jeroen.vocabtrainer.users.command;

import eu.stiekema.jeroen.vocabtrainer.api.users.UserAuthenticatedEvent;
import eu.stiekema.jeroen.vocabtrainer.api.users.UserCreatedEvent;
import eu.stiekema.jeroen.vocabtrainer.api.users.UserId;
import eu.stiekema.jeroen.vocabtrainer.api.users.UserNotAuthenticatedEvent;
import org.axonframework.eventhandling.annotation.EventHandler;
import org.axonframework.eventsourcing.annotation.AbstractAnnotatedAggregateRoot;

/**
 * @author Jeroen Stiekema
 */
public class User extends AbstractAnnotatedAggregateRoot {

    private UserId userId;

    private String password;

    protected User() {
    }

    public User(UserId userId, String userName, String name, String password) {
        apply(new UserCreatedEvent(userId, userName, name, password));
    }

    public boolean authenticate(String password) {
        boolean success = this.password.equals(password);
        if (success) {
            apply(new UserAuthenticatedEvent(userId));
        } else {
            apply(new UserNotAuthenticatedEvent(userId));
        }
        return success;
    }

    @EventHandler
    public void onUserCreated(UserCreatedEvent event) {
        this.userId = event.getUserId();
        this.password = event.getPassword();
    }

    @Override
    public Object getIdentifier() {
        return this.userId.toString();
    }
}
