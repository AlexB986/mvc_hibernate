package web.dao;


import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext //?
    private EntityManager em;

    public UserDaoImpl() {
    }

    @Override
    public User save(User user) {
        em.getTransaction().begin();
        User newUser = new User();
        newUser.setName(user.getName());
        newUser.setCourse(user.getCourse());
        newUser.setEmail(user.getEmail());
        em.persist(user);
        em.getTransaction().commit();
        return newUser;

    }

    @Override
    public void update(Long id, User user) {
        em.getTransaction().begin();
        User findUser = em.find(User.class, id);
        if (findUser != null) {
            findUser.setId(id);
            findUser.setName(user.getName());
            findUser.setCourse(user.getCourse());
            findUser.setEmail(user.getEmail());
            em.merge(findUser);
        }
        System.out.println("Такого id нет");
    }

    @Override
    public void delete(Long id) {
        em.getTransaction().begin();
        User deleteUser = em.find(User.class, id);
        em.remove(deleteUser);
        em.getTransaction().commit();

    }

    @Override
    public User findById(Long id) {
        User userFind = em.find(User.class, id);
        em.detach(userFind);
        return userFind;
    }

    @Override
    public List<User> findAll() {
        em.getTransaction().begin();
        List<User>usersList = em.createQuery("from User").getResultList();
        em.getTransaction().commit();
        return usersList;
    }
}
