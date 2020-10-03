package it.nzt.springdemo.service;

import it.nzt.springdemo.exceptions.InvalidObjectException;
import it.nzt.springdemo.exceptions.NotFoundException;
import it.nzt.springdemo.rest.dto.UserDTO;

import java.util.List;

public interface UserService {
    List<UserDTO> getAllUsers();

    UserDTO getUserById(Integer id) throws NotFoundException;

    UserDTO addUser(UserDTO userDTO) throws InvalidObjectException;
}
