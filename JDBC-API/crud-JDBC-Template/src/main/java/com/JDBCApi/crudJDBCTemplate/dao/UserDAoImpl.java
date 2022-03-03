package com.JDBCApi.crudJDBCTemplate.dao;

import com.JDBCApi.crudJDBCTemplate.dao.UserDao;
import com.JDBCApi.crudJDBCTemplate.domain.User;
import com.JDBCApi.crudJDBCTemplate.exceptions.InvalidIdException;
import com.JDBCApi.crudJDBCTemplate.exceptions.InvalidUserException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAoImpl implements UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    private static final String INSERT_USER_QUERY = "INSERT INTO User(id,name,lastNAme,email) values(?,?,?,?)";
    private static final String UPDATE_USER_QUERY = "UPDATE User SET name=? WHERE id=?";
    private static final String DELETE_USER_QUERY = "DELETE FROM User WHERE id=?";
    private static final String GET_USERS_QUERY = "SELECT * FROM User";

    @Override
    public User createUser(User user) throws InvalidUserException {
        if(user == null) throw new InvalidUserException("user can't be null");
        jdbcTemplate.update(INSERT_USER_QUERY, user.getId(), user.getName(), user.getLastName(), user.getEmail());
        return user;
    }

    @Override
    public User updateUser(User user) {
        jdbcTemplate.update(UPDATE_USER_QUERY, user.getName(), user.getId());
        return user;
    }

    @Override
    public String deleteUser(int id) throws InvalidIdException {
            jdbcTemplate.update(DELETE_USER_QUERY, id);
            return "user got deleted by id " + id;
    }

    @Override
    public List<User> allUsers() {
        return jdbcTemplate.query(GET_USERS_QUERY, (rs, rowNum) -> {
            return new User(rs.getInt("id"), rs.getString("name"), rs.getString("lastName"), rs.getString("email"));
        });
    }
}
