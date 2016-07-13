package com.oocl.mnlbc.hw2;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class UserMapper implements RowMapper<User> {
   public User mapRow(ResultSet rs, int rowNum) throws SQLException {
      User user = new User();
      user.setFname(rs.getString("fname"));
      user.setLname(rs.getString("lname"));
      user.setUname(rs.getString("uname"));
      user.setPassword(rs.getString("password"));
      return user;
   }
}