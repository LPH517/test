package service;

import model.User;

import java.util.List;

public interface UserService {
    public List<User> findAllUsers();
    public void add(User user);
}
