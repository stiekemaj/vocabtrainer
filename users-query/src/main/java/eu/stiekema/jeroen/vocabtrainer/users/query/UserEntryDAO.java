package eu.stiekema.jeroen.vocabtrainer.users.query;

import eu.stiekema.jeroen.vocabtrainer.users.UserEntry;

/**
 * @author Jeroen Stiekema
 */
public interface UserEntryDAO {
    public UserEntry findByUsername(String username);

    public void persist(UserEntry userEntry);
}
