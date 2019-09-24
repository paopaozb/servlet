package dao;

import Entity.User;

import java.util.List;

/**
 * Created by Administrator on 2017/7/4.
 */
public interface UserDao {

    public boolean addUser(User user);

    public void updateUser(User user);

    public void deleteUser(User user);

    public List<User> getUserList();

}
