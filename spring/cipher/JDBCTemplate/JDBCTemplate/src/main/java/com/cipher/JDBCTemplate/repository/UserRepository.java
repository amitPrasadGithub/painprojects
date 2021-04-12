package com.cipher.JDBCTemplate.repository;

import com.cipher.JDBCTemplate.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface UserRepository {
    User saveUser(User user);
    User updateUser(User user);
    User getById(Integer userId);
    User getByIdLegecyWay(Integer userId);
    List<User> getAllUsers();
    Integer deleteById(Integer userId);

    /**
     * GET AS COLLECTION
     * with queryFor method
     */
    List<List<String>> getAllUserAsCollection();
    List<Map<String, Object>> getAsMap();
    List<Map<String, Object>> parameterizedQueryForList(String city);

    /**
     * With Query Method
     */
    List<List<String>> getAllWithQueryMethod(String city);
    List<List<String>> getAllWithQueryMethodLegecyWay(String city);
}
