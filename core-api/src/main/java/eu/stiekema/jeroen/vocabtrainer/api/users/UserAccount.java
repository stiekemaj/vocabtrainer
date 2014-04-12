package eu.stiekema.jeroen.vocabtrainer.api.users;

import org.springframework.security.core.userdetails.UserDetails;

/**
 * @author Jeroen Stiekema
 */
public interface UserAccount extends UserDetails {
    String getUserId();
    String getName();
}
