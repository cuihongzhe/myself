package com.controller;

import com.alibaba.fastjson.JSON;
import com.dataTransform.User;
import com.dataTransform.UserRowMapper;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.sql.DataSource;
import java.sql.Types;
import java.util.Map;
import java.util.List;

@Controller //可以返回视图
//自动为springboot应用进行配置
//@EnableAutoConfiguration
public class HelloController {
    @Autowired
    DataSource dataSource;

    @RequestMapping("/myIndex")
    @ResponseBody
    public String index(@RequestBody String data) {
        Map datamap = (Map) JSON.parse(data);
        //System.out.println("hello.springboot的第一个controller");
        Map loginmap = (Map) JSON.parse(datamap.get("params").toString());
        System.out.println(loginmap);
        String email = loginmap.get("Siemail").toString();
        String password = loginmap.get("Sipassword").toString();
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql = "select * from user where userName = ? and  password = ?";
        int[] types = new int[]{Types.VARCHAR, Types.VARCHAR};
        Object params[] = new Object[]{email, password};
        List<User> queryForList = jdbcTemplate.query(sql, params, types, new UserRowMapper());
        String loginFlag = "0";
        if(queryForList.size()>0){
            loginFlag = "1";
        }
        return loginFlag;
    }
}

