package com.example.demo.repo;

import com.example.demo.model.UserRole;
import com.example.demo.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UserRoleKartotek {


    @Autowired
    JdbcTemplate jdbcTemplate;


    class UserRoleRowMapper implements RowMapper<UserRole>{


        @Override
        public UserRole mapRow(ResultSet resultSet, int i) throws SQLException {
            UserRole userRole = new UserRole();

            userRole.getRole();
            userRole.setUsername(resultSet.getString("username"));
            return userRole;
        }
    }

    public List<UserRole> findAll() {
        return jdbcTemplate.query("select * from user_roles", new UserRoleRowMapper());
    }

    public int insert(UserRole userRole) {
        return jdbcTemplate.update("insert into user_roles (role, username)  " +
                        "values(?, ?)",
                new Object[] {  userRole.getRole(), userRole.getUsername() });
    }
}


