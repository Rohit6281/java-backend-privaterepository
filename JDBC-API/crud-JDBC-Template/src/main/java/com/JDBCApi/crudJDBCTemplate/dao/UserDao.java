package com.JDBCApi.crudJDBCTemplate.dao;

import com.JDBCApi.crudJDBCTemplate.domain.User;
import com.JDBCApi.crudJDBCTemplate.exceptions.InvalidIdException;
import com.JDBCApi.crudJDBCTemplate.exceptions.InvalidUserException;

import java.util.List;

public interface UserDao {
    User createUser(User user) throws InvalidUserException;
    User updateUser(User user);
    String deleteUser(int id) throws InvalidIdException;
    List<User> allUsers();
}
