package eu.stiekema.jeroen.vocabtrainer.users;

import eu.stiekema.jeroen.vocabtrainer.api.users.UserCreatedEvent;
import eu.stiekema.jeroen.vocabtrainer.users.query.UserEntryDAO;
import org.axonframework.eventhandling.annotation.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Jeroen Stiekema
 */
@Service
@Transactional
public class QueryModel {

    @Autowired
    private UserEntryDAO userEntryDAO;

    @EventHandler
    public void handle(UserCreatedEvent event) {
        UserEntry userEntry = new UserEntry();
        userEntry.setIdentifier(event.getUserId().toString());
        userEntry.setName(event.getName());
        userEntry.setUsername(event.getUsername());
        userEntry.setPassword(event.getPassword());
        userEntryDAO.persist(userEntry);
    }
}
