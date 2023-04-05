package com.dataTransform;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @BelongsProject: demo
 * @BelongsPackage: com.controller
 * @Author: cuihzh
 * @CreateTime: 2023-04-05  11:17
 * @Description: TODO
 * @Version: 1.0
 */
public class UserRowMapper  implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new User(rs.getString("userName"), rs.getString("password"));
    }
}
