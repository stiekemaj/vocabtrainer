package eu.stiekema.jeroen.vocabtrainer.service.impl;

import eu.stiekema.jeroen.vocabtrainer.model.User;
import eu.stiekema.jeroen.vocabtrainer.service.UserService;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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


}
