package eu.stiekema.jeroen.vocabtrainer.infra.persistence;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.axonframework.common.jpa.EntityManagerProvider;

/**
 * @author Jeroen Stiekema
 */
public class CQRSEntityManagerProvider implements EntityManagerProvider {
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
