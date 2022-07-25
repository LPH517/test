package service.impl;

import dao.UserDao;
import model.User;
import org.apache.ibatis.session.SqlSession;
import service.UserService;
import util.JDBCUtils;

import java.util.Date;
import java.util.List;

public class UserServiceImpl implements UserService {
    private SqlSession sqlSession = JDBCUtils.getSession();
    private UserDao userDao = sqlSession.getMapper(UserDao.class);
    @Override
    public List<User> findAllUsers() {
        List<User> list = userDao.findALL();
        System.out.println("Serviceimpl...."+list);
        return list;
    }

    @Override
    public void add(User user) {
        Date date = new Date();
        User user1 = new User(0,"jk123","123","jack",date);
        userDao.add(user1);
        sqlSession.commit();
        sqlSession.close();
        System.out.println("add_ok");
    }
}
