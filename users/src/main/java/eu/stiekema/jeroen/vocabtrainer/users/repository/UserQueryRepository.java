package eu.stiekema.jeroen.vocabtrainer.users.repository;

import eu.stiekema.jeroen.vocabtrainer.api.users.UserAccount;

/**
 * @author Jeroen Stiekema
 */
public interface UserQueryRepository {
    UserAccount findByUsername(String username);
}
