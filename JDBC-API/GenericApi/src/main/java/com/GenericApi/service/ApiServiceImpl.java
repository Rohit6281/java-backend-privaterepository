package com.GenericApi.service;

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
    public Object createUser( QueryResponse res) {
        repo.saveUser(res);
        return res.getParam();
    }

    @Override
    public Object updateUser( QueryResponse res) {
        repo.updateByID(res);
        return res.getParam();
    }

    @Override
    public Object[] deleteUser( QueryResponse res) {
        repo.deleteUser(res);
        return res.getParam() ;
    }

    @Override
    public List<Object> allUsers(QueryResponse res) {
        List user = repo.allUsers(res);
        return user;
    }

    @Override
    public Object searchUserByID( QueryResponse res) {
        Object user = repo.getByID(res);
        return user;
    }
}
