package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    public User addUser(User user);
    public void updateUser(Long id, User user);
    public void deleteUser(Long id);
    public User findByIdUser(Long id);
    public List<User> findAllUser();
}
