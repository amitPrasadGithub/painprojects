package com.cipher.JDBCTemplate.rest.controller;

import com.cipher.JDBCTemplate.entity.User;
import com.cipher.JDBCTemplate.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping(value = {"/save"})
    public User saveUser(@RequestBody User user) {
        return userRepository.saveUser(user);
    }

    @GetMapping(value = {"getAll"})
    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }

    @GetMapping(value = {"/getById"})
    public User get(@RequestParam("userId") Integer id) {
        User user = userRepository.getById(id);
        return user;
    }

    @GetMapping(value = {"/getByIdLegecyWay"})
    public User getByIdLegecyWay(@RequestParam("userId") Integer id) {
        return userRepository.getByIdLegecyWay(id);
    }

    /**
     * GET AS COLLECTION
     * with queryFor method
     * @return
     */
    @GetMapping(value = {"/getAsCollection"})
    public List<List<String>> getAsCollection() {
        return userRepository.getAllUserAsCollection();
    }

    @GetMapping(value = {"/getAsMap"})
    public List<Map<String, Object>> getAsMap() {
        return userRepository.getAsMap();
    }

    @GetMapping(value = {"/parameterizedQueryForList"})
    public List<Map<String, Object>> parameterziedQueryForList(@RequestParam("city") String city) {
        return userRepository.parameterizedQueryForList(city);
    }

    /**
     * With query method
     */
    @GetMapping(value = {"/getAllWithQueryMethod"})
    public List<List<String>> getAllWithQueryMethod(@RequestParam("city") String city) {
        return userRepository.getAllWithQueryMethod(city);
    }

    @GetMapping(value = {"/getAllWithQueryMethodLegecyWay"})
    public List<List<String>> getAllWithQueryMethodLegecyWay(@RequestParam("city") String city) {
        return userRepository.getAllWithQueryMethodLegecyWay(city);
    }
}
