package eu.stiekema.jeroen.vocabtrainer;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.axonframework.common.jpa.EntityManagerProvider;

/**
 * @author Jeroen Stiekema
 */
public class MyEntityManagerProvider implements EntityManagerProvider {
    private EntityManager entityManager;

    @Override
    public EntityManager getEntityManager() {
        return this.entityManager;
    }

    @PersistenceContext(unitName = "VocabTrainer")
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
