package eu.stiekema.jeroen.vocabtrainer.model;

import java.util.List;

/**
 * @author Jeroen Stiekema
 */
public interface Item {
    String getDescription();
    List<? extends Item> getChildItems();
}
