package it.nzt.springdemo.rest.controller;

import it.nzt.springdemo.exceptions.InvalidObjectException;
import it.nzt.springdemo.exceptions.NotFoundException;
import it.nzt.springdemo.rest.dto.UserDTO;
import it.nzt.springdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(path="")
    public ResponseEntity<List<UserDTO>> getAll() {
        List<UserDTO> allUsers = userService.getAllUsers();
        return ResponseEntity.ok(allUsers);
    }

    @GetMapping(path="/{id}")
    public ResponseEntity<UserDTO> getById(@PathVariable Integer id) throws NotFoundException {
        UserDTO user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }

    @PostMapping(path="")
    public ResponseEntity<UserDTO> addUser(@RequestBody UserDTO userDTO) throws InvalidObjectException {
        UserDTO addedUser = userService.addUser(userDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedUser);
    }

}
