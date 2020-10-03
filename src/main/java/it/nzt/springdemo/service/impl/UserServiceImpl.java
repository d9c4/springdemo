package it.nzt.springdemo.service.impl;

import it.nzt.springdemo.exceptions.InvalidObjectException;
import it.nzt.springdemo.exceptions.NotFoundException;
import it.nzt.springdemo.rest.dto.UserDTO;
import it.nzt.springdemo.service.UserService;
import it.nzt.springdemo.service.actions.UserAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserAction userAction;

    @Override
    public List<UserDTO> getAllUsers() {
        return userAction.getAllUsers().stream().map(UserDTO::toDTO).collect(Collectors.toList());
    }

    @Override
    public UserDTO getUserById(Integer id) throws NotFoundException {
        return UserDTO.toDTO(userAction.getUserById(id));
    }

    @Override
    public UserDTO addUser(UserDTO userDTO) throws InvalidObjectException {
        return UserDTO.toDTO(userAction.addUser(UserDTO.toModel(userDTO)));
    }
}
