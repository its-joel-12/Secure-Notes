package com.secure.notes.service;

import com.secure.notes.dtos.UserDTO;
import com.secure.notes.model.User;

import java.util.List;

public interface UserService {
    void updateUserRole(Long userId, String roleName);

    List<User> getAllUsers();

    UserDTO getUserById(Long id);
}