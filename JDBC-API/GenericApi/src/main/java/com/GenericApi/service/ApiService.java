package com.GenericApi.service;

import com.GenericApi.domain.User;
import com.GenericApi.dto.QueryResponse;

import java.util.List;

public interface ApiService {
    User createUser(User user, QueryResponse res);

    User updateUser(User user, QueryResponse res);

    String deleteUser(int id, QueryResponse res);

    List<User> allUsers(QueryResponse res);

    User searchUserByID( QueryResponse res);
}


