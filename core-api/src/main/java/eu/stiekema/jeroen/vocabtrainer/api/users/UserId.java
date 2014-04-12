package eu.stiekema.jeroen.vocabtrainer.api.users;

import org.axonframework.domain.IdentifierFactory;

/**
 * @author Jeroen Stiekema
 */
public class UserId {

    private String identifier;

    public UserId() {
        this.identifier = IdentifierFactory.getInstance().generateIdentifier();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        UserId userId = (UserId) o;

        if (!identifier.equals(userId.identifier)) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        return identifier.hashCode();
    }

    @Override
    public String toString() {
        return this.identifier;
    }
}
