package eu.stiekema.jeroen.vocabtrainer.event;

/**
 * @author Jeroen Stiekema
 */
public class AddSubjectEvent {
    private final String subjectId;
    private final String name;
    private final String description;

    public AddSubjectEvent(String subjectId, String name, String description) {
        this.subjectId = subjectId;
        this.name = name;
        this.description = description;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
