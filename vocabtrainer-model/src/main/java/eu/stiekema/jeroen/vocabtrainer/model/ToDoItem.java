package eu.stiekema.jeroen.vocabtrainer.model;

import eu.stiekema.jeroen.vocabtrainer.command.CreateToDoItemCommand;
import eu.stiekema.jeroen.vocabtrainer.event.ToDoItemCreatedEvent;
import org.axonframework.commandhandling.annotation.CommandHandler;
import org.axonframework.eventhandling.annotation.EventHandler;
import org.axonframework.eventsourcing.annotation.AbstractAnnotatedAggregateRoot;
import org.axonframework.eventsourcing.annotation.AggregateIdentifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Jeroen Stiekema
 */
public class ToDoItem extends AbstractAnnotatedAggregateRoot {
    private static final Logger logger = LoggerFactory.getLogger(ToDoItem.class);

    @AggregateIdentifier
    private String id;

    public ToDoItem() {
    }

    @CommandHandler
    public ToDoItem(CreateToDoItemCommand command) {
        apply(new ToDoItemCreatedEvent(command.getTodoId(), command.getDescription()));
    }

    @EventHandler
    public void on(ToDoItemCreatedEvent event) {
        this.id = event.getTodoId();
        logger.info(String.format("handle event with id %s", this.id));
    }
}
