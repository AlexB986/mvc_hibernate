package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {
    public User save(User user);
    public void update(Long id,User user);
    public void delete(Long id);
    public User findById(Long id);
    public List<User> findAll();
}
