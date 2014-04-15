package eu.stiekema.jeroen.vocabtrainer.service.impl;

import eu.stiekema.jeroen.vocabtrainer.model.User;
import eu.stiekema.jeroen.vocabtrainer.service.UserService;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 * @author Jeroen Stiekema
 */
@Stateless
public class UserServiceImpl implements UserService {

    @PersistenceContext(name = "vocabTrainerPU")
    private EntityManager em;

    @Override
    public User getUserById(Long id) {
        return em.find(User.class, id);
    }

    @Override
    public User getUserByEmailAddress(String emailAddress) {
        TypedQuery<User> query = em.createNamedQuery("User.getByEmailAddress", User.class);
        query.setParameter("emailAddress", emailAddress);
        return query.getSingleResult();
    }

    @Override
    public void detachUser(User user) {
        em.detach(user);
    }

}
