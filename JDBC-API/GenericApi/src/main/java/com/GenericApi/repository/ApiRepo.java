package com.GenericApi.repository;

import com.GenericApi.domain.User;
import com.GenericApi.dto.QueryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ApiRepo {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public User saveUser(QueryResponse res, User user) {
        jdbcTemplate.update(res.getQuery(),
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail());
        return user;
    }

    public int deleteUser(QueryResponse res, int id) {
        return jdbcTemplate.update(res.getQuery(), id);
    }

    public List<User> allUsers(QueryResponse res) {
        List<User> user = jdbcTemplate.query(res.getQuery(),
                new BeanPropertyRowMapper<>(User.class));
        return user;
    }

    public User getByID(QueryResponse res) {
        String param = res.getQuery() + res.getParam();
        System.out.println(param);
        User user = (User) jdbcTemplate.queryForObject(param,
                new BeanPropertyRowMapper<>(User.class));

        return user;
    }

    public User updateByID(QueryResponse res, User user) {
        jdbcTemplate.update(res.getQuery(), user.getEmail(),user.getId());
        return user;

    }

}
