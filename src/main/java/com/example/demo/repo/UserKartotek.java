package com.example.demo.repo;

import com.example.demo.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import org.springframework.jdbc.core.RowMapper;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


@Repository
public class UserKartotek {


    @Autowired
    JdbcTemplate jdbcTemplate;

    class UserRowMapper implements RowMapper<Users> {

        @Override
        public Users mapRow(ResultSet rs, int rowNum) throws SQLException {
            Users users = new Users();
            users.setUsername(rs.getString("username"));
            users.setPassword(rs.getString("password"));
            return users;
        }

    }


    public List<Users> findAll() {
        return jdbcTemplate.query("select * from users", new UserRowMapper());
    }


    public int insert(Users users) {
        return jdbcTemplate.update("insert into users (username, password) " +
                        "values(?, ?)",
                new Object[] {  users.getUsername(), users.getPassword() });
    }

}


