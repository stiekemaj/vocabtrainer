package eu.stiekema.jeroen.vocabtrainer.springmvc.security;

import eu.stiekema.jeroen.vocabtrainer.api.users.AuthenticateUserCommand;
import eu.stiekema.jeroen.vocabtrainer.api.users.UserAccount;
import java.util.Collection;
import java.util.HashSet;
import java.util.concurrent.ExecutionException;
import org.axonframework.commandhandling.CommandBus;
import org.axonframework.commandhandling.GenericCommandMessage;
import org.axonframework.commandhandling.callbacks.FutureCallback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

/**
 * @author Jeroen Stiekema
 */
@Component
public class VocabTrainerAuthenticationProvider implements AuthenticationProvider {

    private static Logger log = LoggerFactory.getLogger(VocabTrainerAuthenticationProvider.class);

    private final static Collection<GrantedAuthority> userAuthorities;

    static {
        userAuthorities = new HashSet<GrantedAuthority>();
        userAuthorities.add(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Autowired
    private CommandBus commandBus;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        if (!supports(authentication.getClass())) {
            return null;
        }

        UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) authentication;
        FutureCallback<UserAccount> userAccountFutureCallback = new FutureCallback<UserAccount>();
        AuthenticateUserCommand command = new AuthenticateUserCommand(token.getName(), String.valueOf(token.getCredentials()));

        commandBus.dispatch(new GenericCommandMessage<AuthenticateUserCommand>(command), userAccountFutureCallback);
        try {
            UserAccount userAccount = userAccountFutureCallback.get();
            if (userAccount == null) {
                throw new BadCredentialsException("Invalid username and/or password");
            }
            UsernamePasswordAuthenticationToken returnVal = new UsernamePasswordAuthenticationToken(userAccount, authentication.getCredentials(), userAuthorities);
            returnVal.setDetails(authentication.getDetails());
            return returnVal;
        } catch (InterruptedException e) {
            throw new AuthenticationServiceException("Credentials could not be verified", e);
        } catch (ExecutionException e) {
            log.error("ExecutionException while authenticating user", e);
            throw new AuthenticationServiceException("Credentials could not be verified", e);
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
