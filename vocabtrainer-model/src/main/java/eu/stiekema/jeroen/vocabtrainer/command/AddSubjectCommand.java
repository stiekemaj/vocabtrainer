package eu.stiekema.jeroen.vocabtrainer.command;

import org.axonframework.commandhandling.annotation.TargetAggregateIdentifier;

/**
 * @author Jeroen Stiekema
 */
public class AddSubjectCommand {
    @TargetAggregateIdentifier
    private String subjectId;
    private String name;
    private String description;

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
