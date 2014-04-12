package eu.stiekema.jeroen.vocabtrainer.users.command;

import eu.stiekema.jeroen.vocabtrainer.api.users.AuthenticateUserCommand;
import eu.stiekema.jeroen.vocabtrainer.api.users.CreateUserCommand;
import eu.stiekema.jeroen.vocabtrainer.api.users.UserAccount;
import eu.stiekema.jeroen.vocabtrainer.api.users.UserId;
import eu.stiekema.jeroen.vocabtrainer.users.UserEntry;
import eu.stiekema.jeroen.vocabtrainer.users.query.UserEntryDAO;
import org.axonframework.commandhandling.annotation.CommandHandler;
import org.axonframework.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @author Jeroen Stiekema
 */
@Component
public class UserCommandHandler {

    @Autowired
    @Qualifier("userRepository")
    private Repository<User> repository;

    @Autowired
    private UserEntryDAO userEntryDAO;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @CommandHandler
    public UserId handleCreateUser(CreateUserCommand command) {
        UserId identifier = command.getUserId();
        User user = new User(identifier, command.getUsername(), command.getName(), passwordEncoder.encode(command.getPassword()));
        repository.add(user);
        return identifier;
    }

    @CommandHandler
    public UserAccount handleAuthenticateUser(AuthenticateUserCommand command) {
        UserEntry userEntry = userEntryDAO.findByUsername(command.getUsername());
        if (userEntry == null) {
            return null;
        }

        User user = repository.load(userEntry.getIdentifier());
        if (user.authenticate(passwordEncoder.encode(command.getPassword()))) {
            return userEntry;
        }

        return null;
    }

}
