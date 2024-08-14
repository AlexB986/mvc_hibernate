package web.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.UserDao;
import web.model.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Transactional
    @Override
    public User addUser(User user) {
        return userDao.save(user);

    }

    @Override
    public void updateUser(Long id, User user) {
        userDao.update(id,user);

    }


    @Transactional
    @Override
    public void deleteUser(Long id) {
        userDao.delete(id);
    }

    @Transactional
    @Override
    public User findByIdUser(Long id) {
        return userDao.findById(id);
    }

    @Override
    public List<User> findAllUser() {
        return userDao.findAll();
    }
}
