package it.nzt.springdemo.service.actions;

import it.nzt.springdemo.data.model.User;
import it.nzt.springdemo.exceptions.InvalidObjectException;
import it.nzt.springdemo.exceptions.NotFoundException;

import java.util.List;

public interface UserAction {
    List<User> getAllUsers();

    User getUserById(Integer id) throws NotFoundException;

    User addUser(User user) throws InvalidObjectException;
}
