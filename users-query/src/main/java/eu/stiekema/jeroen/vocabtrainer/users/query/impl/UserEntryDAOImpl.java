package eu.stiekema.jeroen.vocabtrainer.users.query.impl;

import eu.stiekema.jeroen.vocabtrainer.users.query.UserEntryDAO;
import eu.stiekema.jeroen.vocabtrainer.users.UserEntry;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

/**
 * @author Jeroen Stiekema
 */
@Repository
public class UserEntryDAOImpl implements UserEntryDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public UserEntry findByUsername(String username) {
        TypedQuery<UserEntry> query = entityManager.createQuery("select o from UserEntry o where o.username = :username", UserEntry.class);
        query.setParameter("username", username);
        try {
             return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public void persist(UserEntry userEntry) {
        entityManager.persist(userEntry);
    }
}
