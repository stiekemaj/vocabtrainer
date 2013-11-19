package eu.stiekema.jeroen.vocabtrainer.model;

import java.util.Collections;
import java.util.List;

/**
 * @author Jeroen Stiekema
 */
public class Question implements Item {

    private String description;

    private List<Answer> answerList;

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public List<Answer> getChildItems() {
        return Collections.unmodifiableList(this.answerList);
    }
}
