package it.nzt.springdemo.service.actions.impl;

import it.nzt.springdemo.data.model.User;
import it.nzt.springdemo.data.repository.UserRepository;
import it.nzt.springdemo.exceptions.InvalidObjectException;
import it.nzt.springdemo.exceptions.NotFoundException;
import it.nzt.springdemo.service.actions.UserAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserActionImpl implements UserAction {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Integer id) throws NotFoundException {
        Optional<User> maybeUser = userRepository.findById(id);
        if(maybeUser.isEmpty())
            throw new NotFoundException("User not found");

        return maybeUser.get();

    }

    @Override
    public User addUser(User user) throws InvalidObjectException {
        if(user.isValid())
            return userRepository.save(user);

        throw new InvalidObjectException("Invalid user");
    }
}
