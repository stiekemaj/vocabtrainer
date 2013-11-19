package eu.stiekema.jeroen.vocabtrainer;

import eu.stiekema.jeroen.vocabtrainer.command.CreateToDoItemCommand;

/**
 * @author Jeroen Stiekema
 */
public interface VocabTrainerService {
    void createToDoItem(CreateToDoItemCommand command);
}
