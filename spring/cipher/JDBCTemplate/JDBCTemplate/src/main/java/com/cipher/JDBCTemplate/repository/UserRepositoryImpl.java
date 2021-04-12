package com.cipher.JDBCTemplate.repository;

import com.cipher.JDBCTemplate.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class UserRepositoryImpl implements UserRepository {
    private static final String INSERT_USER = "insert into user (user_id, fname, lname, email) values(?, ?, ?, ?)";
    private static final String UPDATE_USER = "update user set fname = ? where user_id = ?";
    private static final String GET_USER_BY_ID = "select u.user_id, u.fname, u.lname, u.email, a.city from user u join address a where u.user_id = ?";
    private static final String DELETE_FROM_USER_BY_ID = "delete from user where user_id = ?";
    private static final String GET_All_USER = "select u.user_id, u.fname, u.lname, u.email, a.city from user u join address a where u.user_id = a.address_id";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public User saveUser(User user) {
        System.out.print(user.getFname());
        jdbcTemplate.update(INSERT_USER, user.getUserId(), user.getFname(), user.getLname(), user.getEmail());
        return user;
    }

    @Override
    public User updateUser(User user) {
        jdbcTemplate.update(UPDATE_USER, user.getFname(), user.getUserId());
        return user;
    }

    @Override
    public User getById(Integer userId) {
        return jdbcTemplate.queryForObject(
                "select u.user_id, u.fname, u.lname, u.email, a.city from user u join address a where u.user_id = a.address_id and u.user_id = ?",
                new Object[]{userId.intValue()},
                (resultSet, i) -> {
                    User user = new User(
                           resultSet.getInt("user_id"),
                           resultSet.getString("fname"),
                           resultSet.getString("lname"),
                           resultSet.getString("email")
                   );
                    return user;
                });
    }

    public User getByIdLegecyWay(Integer id) {
        return jdbcTemplate.queryForObject(
                GET_USER_BY_ID,
                new Object[]{id},
                new RowMapper<User>() {
                    @Override
                    public User mapRow(ResultSet resultSet, int i) throws SQLException {
                        User user = null;
                        while (resultSet.next()) {
                            user = new User(
                                resultSet.getInt("user_id"),
                                resultSet.getString("fname"),
                                resultSet.getString("lname"),
                                resultSet.getString("email")
                            );
                        }
                        return user;
                    }
                }
        );
    }

    @Override
    public List<User> getAllUsers() {
        List<Map<String, Object>> list = jdbcTemplate.queryForList(
                "select u.fname, a.city from user u join address a where u.user_id = a.address_id");

        return list.stream()
                .map(
                        (m) -> {
                            User user = new User();
                            user.setFname((String)m.get("fname"));

                            return user;
                        }
                )
                .collect(Collectors.toList());
    }

    @Override
    public Integer deleteById(Integer userId) {
        return 1;
    }

    /**
     * GET AS COLLECTION
     * with queryFor method
     */
    @Override
    public List<List<String>> getAllUserAsCollection() {
        List<Map<String, Object>> list = jdbcTemplate.queryForList(
                "select u.fname, u.email, a.city from user u join address a where u.user_id = a.address_id");
        return list.stream()
                .map(
                        (m) -> {
                            List<String> s_list = new ArrayList();
                            s_list.add((String)m.get("fname"));
                            s_list.add((String)m.get("email"));
                            s_list.add((String)m.get("city"));

                            return s_list;
                        }
                )
                .collect(Collectors.toList());
    }

    public List<Map<String, Object>> getAsMap() {
        List<Map<String, Object>> list = jdbcTemplate.queryForList("select u.fname, u.email, a.city from user u join address a where u.user_id = a.address_id");

        return list;
    }

    @Override
    public List<Map<String, Object>> parameterizedQueryForList(String city) {
        List<Map<String, Object>> list = jdbcTemplate.queryForList(
                "select u.fname, u.email, a.city from user u join address a where u.user_id = a.address_id and a.city = ?",
                new Object[] {city}
        );

        return list;
    }

    /**
     * Get with Query method
     */
    @Override
    public List<List<String>> getAllWithQueryMethod(String city) {
        return jdbcTemplate.query(
                "select u.fname, u.email, a.city from user u join address a where u.user_id = a.address_id and a.city = ?",
                new Object[] {city},
                ((resultset, i) -> {
                    List<String> list = new ArrayList();
                    list.add(resultset.getString("fname"));
                    list.add(resultset.getString("email"));
                    list.add(resultset.getString("city"));
                    return list;
                })
        );
    }

    @Override
    public List<List<String>> getAllWithQueryMethodLegecyWay(String city) {
        return jdbcTemplate.query(
                "select u.fname, u.email, a.city from user u join address a where u.user_id = a.address_id and a.city = ?",
                new Object[]{city},
                new ResultSetExtractor<List<List<String>>>() {
                    @Override
                    public List<List<String>> extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                        List<List<String>> q_list = new ArrayList<>();
                        while(resultSet.next()) {
                            List<String> list = new ArrayList();
                            list.add(resultSet.getString("fname"));
                            list.add(resultSet.getString("email"));
                            list.add(resultSet.getString("city"));

                            q_list.add(list);
                        }
                        return q_list;
                    }
                }
        );
    }
}
