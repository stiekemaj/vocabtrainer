package eu.stiekema.jeroen.vocabtrainer;

import eu.stiekema.jeroen.vocabtrainer.command.AddSubjectCommand;
import eu.stiekema.jeroen.vocabtrainer.command.CreateToDoItemCommand;
import eu.stiekema.jeroen.vocabtrainer.gateway.CreateToDoItemGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Jeroen Stiekema
 */
@Service
public class VocabTrainerServiceImpl implements VocabTrainerService {

    @Autowired
    private CreateToDoItemGateway commandGateway;

    @Override
    public void createToDoItem(CreateToDoItemCommand command) {
        commandGateway.sendCommand(command);
    }

    @Override
    public void addSubject(AddSubjectCommand addSubjectCommand) {
        commandGateway.sendCommand(addSubjectCommand);
    }
}
