package eu.stiekema.jeroen.vocabtrainer;

import eu.stiekema.jeroen.vocabtrainer.command.AddSubjectCommand;
import eu.stiekema.jeroen.vocabtrainer.command.CreateToDoItemCommand;

/**
 * @author Jeroen Stiekema
 */
public interface VocabTrainerService {
    void createToDoItem(CreateToDoItemCommand command);

    void addSubject(AddSubjectCommand addSubjectCommand);
}
