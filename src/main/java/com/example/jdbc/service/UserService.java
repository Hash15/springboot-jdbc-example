package com.example.jdbc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jdbc.dao.UserDao;
import com.example.jdbc.model.User;

@Service
public class UserService {
	@Autowired
    private UserDao userDAO;

    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    public int addUser(User user) {
        return userDAO.addUser(user);
    }
    
    public int updateUser(Long id, User user) {
        return userDAO.updateUser(id, user);
    }

    public int deleteUser(Long id) {
        return userDAO.deleteUser(id);
    }

}
