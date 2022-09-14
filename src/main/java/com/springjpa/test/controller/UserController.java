package com.springjpa.test.controller;

import com.springjpa.test.entity.Users;
import com.springjpa.test.services.UserService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

  @Autowired
  private UserService userService;

  @PostMapping("/addUser")
  public Users addUser(@RequestBody Users users) {
    return userService.createUser(users);
  }

  @PostMapping("/addUsers")
  public List<Users> addUsers(@RequestBody List<Users> users) {
    return userService.createUsers(users);
  }

  @GetMapping("/getUser/{id}")
  public Optional<Users> getUserById(@PathVariable int id) {
    return userService.getUserById(id);
  }

  @GetMapping("/getAllUsers")
  public List<Users> getAllUsers() {
    return userService.getUsers();
  }

  @PutMapping("/updateUser")
  public Users updateUser(@RequestBody Users users) {
    return userService.updateUser(users);
  }

  @DeleteMapping("/deleteUser/{id}")
  public String deleteUser(@PathVariable int id) {
    return userService.deleteUserById(id);
  }

}
