package eu.stiekema.jeroen.vocabtrainer.model;

import eu.stiekema.jeroen.vocabtrainer.command.CreateToDoItemCommand;
import eu.stiekema.jeroen.vocabtrainer.event.ToDoItemCreatedEvent;
import org.axonframework.test.FixtureConfiguration;
import org.axonframework.test.Fixtures;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Jeroen Stiekema
 */
public class ToDoItemTest {
    private FixtureConfiguration<ToDoItem> fixtureConfiguration;

    @Before
    public void setUp() throws Exception {
        fixtureConfiguration = Fixtures.newGivenWhenThenFixture(ToDoItem.class);
    }

    @Test
    public void testCreateToDoItem() throws Exception {
        fixtureConfiguration.given()
                .when(new CreateToDoItemCommand("todo1", "need to implement the aggregate"))
                .expectEvents(new ToDoItemCreatedEvent("todo1", "need to implement the aggregate"));
    }

//    @Test
//    public void testMarkToDoItemAsCompleted() throws Exception {
//        fixtureConfiguration.given(new ToDoItemCreatedEvent("todo1", "need to implement the aggregate"))
//                .when(new MarkCompletedCommand("todo1"))
//                .expectEvents(new ToDoItemCompletedEvent("todo1"));
//    }

}
