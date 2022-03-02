package com.JDBCApi.crudJDBCTemplate.dao;

import com.JDBCApi.crudJDBCTemplate.domain.User;

import java.util.List;

public interface UserDao {
    User createUser(User user);
    User updateUser(User user);
    String deleteUser(int id);
    List<User> allUsers();
}
