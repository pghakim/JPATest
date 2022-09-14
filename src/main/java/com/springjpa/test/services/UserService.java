package com.springjpa.test.services;

import com.springjpa.test.entity.Users;
import com.springjpa.test.repositories.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  @Autowired
  private UserRepository userRepository;

  public Users createUser(Users users) {
    return userRepository.save(users);
  }

  public List<Users> createUsers(List<Users> users) {
    return userRepository.saveAll(users);
  }

  public Optional<Users> getUserById(int id) {
    return userRepository.findById(id);
  }

  public List<Users> getUsers() {
    return userRepository.findAll();
  }

  public Users updateUser(Users users) {
    Optional<Users> optionalUser = userRepository.findById(users.getId());
    Users oldUsers;
    if (optionalUser.isPresent()) {
      oldUsers = optionalUser.get();
      oldUsers.setName(users.getName());
      oldUsers.setAddress(users.getAddress());
      oldUsers.setId(users.getId());
      userRepository.save(oldUsers);
    } else {
      return new Users();
    }
    return oldUsers;
  }

  public String deleteUserById(int id) {
    userRepository.deleteById(id);
    return "User " + id + " deleted.";

  }

}
