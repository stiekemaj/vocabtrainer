package eu.stiekema.jeroen.vocabtrainer.service;

import eu.stiekema.jeroen.vocabtrainer.model.User;
import javax.ejb.Local;
import javax.validation.constraints.Min;

/**
 * @author Jeroen Stiekema
 */
@Local
public interface UserService {
    User getUserById(@Min(1) Long id);

    User getUserByEmailAddress(String emailAddress);

    void detachUser(User user);
}
