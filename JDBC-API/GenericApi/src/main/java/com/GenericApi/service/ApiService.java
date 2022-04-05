package com.GenericApi.service;


import com.GenericApi.dto.QueryResponse;

import java.util.List;

public interface ApiService {
    Object createUser( QueryResponse res);

    Object updateUser( QueryResponse res);

    Object deleteUser( QueryResponse res);

    List<Object> allUsers(QueryResponse res);

    Object searchUserByID( QueryResponse res);
}


