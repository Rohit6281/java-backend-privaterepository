package com.JDBCApi.crudJDBCTemplate.dao;

import com.JDBCApi.crudJDBCTemplate.dao.UserDao;
import com.JDBCApi.crudJDBCTemplate.domain.User;
import com.JDBCApi.crudJDBCTemplate.exceptions.*;
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
        if (user == null) throw new InvalidUserException("user can't be null");
        jdbcTemplate.update(INSERT_USER_QUERY, user.getId(), user.getName(), user.getLastName(), user.getEmail());
        return user;
    }

    @Override
    public User updateUser(User user) {

        if (user.getId() == 0) {
            throw new FieldEmptyException("Oops ! Please Enter Proper Data in All The Fields !");
        }
        if (user.getName() == null || user.getEmail() == null) {
            throw new FieldEmptyException("Oops ! Please Enter Proper Data in All The Fields !");
        }
        List<User> lists = jdbcTemplate.query(GET_USERS_QUERY, (rs, rowNum) ->
                new User(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("lastName"),
                        rs.getString("email")
                ));
        var users = lists.stream().anyMatch(user1 -> user1.getId() == user.getId());
        if (users) {
            jdbcTemplate.update(UPDATE_USER_QUERY, user.getName(), user.getId());
            return user;
        } else
            throw new DataNotFoundException("Oops ! Entered Data is Not Found at the Database ! ");
    }

    @Override
    public String deleteUser(int id) throws InvalidIdException {
        List<User> lists = jdbcTemplate.query(GET_USERS_QUERY, (rs, rowNum) ->
                new User(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("lastName"),
                        rs.getString("email"))
        );
        var users = lists.stream().anyMatch(user -> user.getId() == id);

        if (users) {
            jdbcTemplate.update(DELETE_USER_QUERY, id);
            return "user got deleted by id " + id;
        } else
            throw new InvalidIdException("Entered Id is Not Present Kindly Check ! ");
    }

    @Override
    public List<User> allUsers() {
        List<User> users = jdbcTemplate.query(GET_USERS_QUERY, (rs, rowNum) ->
                new User(rs.getInt("id"), rs.getString("name"), rs.getString("lastName"), rs.getString("email"))
        );
        if (users.isEmpty()) {
            throw new NoRecordsException("Records Has Been Empty !!");
        }
        return users;
    }
}
