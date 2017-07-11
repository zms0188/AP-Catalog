package com.autoparts.dao.interfaces;


import com.autoparts.dao.entity.User;

import java.sql.SQLException;

/**
 * Created by zms01 on 03.07.2017.
 */
public interface UserDAO {
    public void addUser(User user) throws SQLException;
    public void updateUser(User user) throws SQLException;
    public User getUserById(Long id) throws SQLException;
    public java.util.List getAllUsers()throws SQLException;
    public void deleteUser(User user)throws SQLException;
}
