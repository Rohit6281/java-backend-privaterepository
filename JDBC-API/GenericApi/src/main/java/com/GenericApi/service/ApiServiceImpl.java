package com.GenericApi.service;

import com.GenericApi.domain.User;
import com.GenericApi.dto.QueryResponse;
import com.GenericApi.repository.ApiRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApiServiceImpl implements ApiService {

    @Autowired
    private ApiRepo repo;


    private static final String INSERT_USER_QUERY = "insert into User(id,name,surName,emailId,password) values(?,?,?,?,?)";
    private static final String UPDATE_USER_QUERY = "update User SET name=?,emailId=? where id=?";
    private static final String DELETE_USER_QUERY = "delete from User where id=?";
    private static final String GET_USERS_QUERY = "select * from User";
    private static final String GET_USERS_BY_ID_QUERY = "select * from User where id=?";

    @Override
    public User createUser(User user, QueryResponse res) {
        User user1 = repo.saveUser(res, user);
        return user1;
    }

    @Override
    public User updateUser(User user, QueryResponse res) {
        var user1 = repo.updateByID(res, user);
        return null;
    }

    @Override
    public String deleteUser(int id, QueryResponse res) {
        repo.deleteUser(res, id);
        return "deleted user by primary key" + id;
    }

    @Override
    public List<User> allUsers(QueryResponse res) {
        List<User> user = repo.allUsers(res);
        return user;
    }

    @Override
    public User searchUserByID( QueryResponse res) {
        User user = repo.getByID(res);
        return user;
    }
}
