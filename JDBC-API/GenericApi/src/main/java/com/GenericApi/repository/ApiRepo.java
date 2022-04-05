package com.GenericApi.repository;

import com.GenericApi.dto.QueryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class ApiRepo {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Object getByID(QueryResponse res){
        String query = res.getQuery();
        Object[] myParms = res.getParam();
        int[] paramType = res.getParamType();
        System.out.println(query);
        List<Map<String,Object>> user = jdbcTemplate.queryForList(query,myParms);
        return  user;
    }

    public Object saveUser(QueryResponse res) {
        return jdbcTemplate.update(res.getQuery(),res.getParam());
    }

    public int deleteUser(QueryResponse res) {
        return jdbcTemplate.update(res.getQuery(),res.getParam());
    }

    public List allUsers(QueryResponse res) {
        List user = jdbcTemplate.queryForList(res.getQuery());
        return user;
    }

    public Object updateByID(QueryResponse res) {
       return  jdbcTemplate.update(res.getQuery(), res.getParam());


    }

}
