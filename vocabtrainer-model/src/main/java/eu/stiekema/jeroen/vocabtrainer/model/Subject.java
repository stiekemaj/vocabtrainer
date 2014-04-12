package eu.stiekema.jeroen.vocabtrainer.model;

import eu.stiekema.jeroen.vocabtrainer.command.AddSubjectCommand;
import eu.stiekema.jeroen.vocabtrainer.event.AddSubjectEvent;
import org.axonframework.commandhandling.annotation.CommandHandler;
import org.axonframework.eventhandling.annotation.EventHandler;
import org.axonframework.eventsourcing.annotation.AbstractAnnotatedAggregateRoot;
import org.axonframework.eventsourcing.annotation.AggregateIdentifier;

/**
 * @author Jeroen Stiekema
 */
public class Subject extends AbstractAnnotatedAggregateRoot {

    @AggregateIdentifier
    private String id;

    public Subject() {
    }

    @CommandHandler
    public Subject(AddSubjectCommand command) {
        apply(new AddSubjectEvent(command.getSubjectId(), command.getName(), command.getDescription()));
    }

    @EventHandler
    public void on(AddSubjectEvent event) {
        this.id = event.getSubjectId();
    }
}
