package com.example.demo.repo;

import com.example.demo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepo {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public User findByUsername(String username) {

        try {
            User user = jdbcTemplate.queryForObject("SELECT id,username,password FROM usr where username=?"
                    , (rs, i) -> new User(rs.getLong("id")
                            , rs.getString("username")
                            , rs.getString("password")), username
            );

            System.out.println(user);
            return user;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
