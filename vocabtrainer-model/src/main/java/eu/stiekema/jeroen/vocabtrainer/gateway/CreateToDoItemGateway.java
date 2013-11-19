package eu.stiekema.jeroen.vocabtrainer.gateway;

import eu.stiekema.jeroen.vocabtrainer.command.CreateToDoItemCommand;

/**
 * @author Jeroen Stiekema
 */
public interface CreateToDoItemGateway {
    void sendCommand(CreateToDoItemCommand command);
}