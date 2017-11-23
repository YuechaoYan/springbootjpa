package com.yychao.springbootjpa.controller;

import com.yychao.springbootjpa.dao.UserDao;
import com.yychao.springbootjpa.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    @Autowired
    private UserDao userDao;
    @RequestMapping("s")
    @ResponseBody
    public String getByEmail(String email) {
        String userId;
        User user = userDao.findByEmail(email);
        if (user != null) {
            userId = String.valueOf(user.getId());
            return "The user id is: " + userId;
        }
        return "user " + email + " is not exist.";
    }
}