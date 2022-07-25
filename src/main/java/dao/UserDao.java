package dao;

import model.User;

import java.util.List;

public interface UserDao {
    public List<User> findALL();
    public void deleteByUid(int uid);
    public void add(User user);
    public void update(User user);
}
