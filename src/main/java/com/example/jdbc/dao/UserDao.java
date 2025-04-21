package com.example.jdbc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.example.jdbc.model.User;

@Repository
public class UserDao {

	@Autowired
    private JdbcTemplate jdbcTemplate;

    public List<User> getAllUsers() {
    	return jdbcTemplate.query("SELECT * FROM users", new UserRowMapper());

    }

    public int addUser(User user) {
        String sql = "INSERT INTO users (name, email) VALUES (?, ?)";
        return jdbcTemplate.update(sql, user.getName(), user.getEmail());
    }
    
    public int updateUser(Long id, User user) {
        String sql = "UPDATE users SET name = ?, email = ? WHERE id = ?";
        return jdbcTemplate.update(sql, user.getName(), user.getEmail(), id);
    }

    public int deleteUser(Long id) {
        String sql = "DELETE FROM users WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }
}
