package com.gdtico.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.gdtico.common.R;
import com.gdtico.entity.User;
import com.gdtico.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @PostMapping("/sendMsg")
    public R<String> sendMsg(@RequestBody User user, HttpSession session){
        return R.success("手机验证码已发送 请注意接收");
    }

    @PostMapping("/login")
    public R<User> login(@RequestBody Map user, HttpSession session){
        String phone = user.get("phone").toString();
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getPhone,phone);
        User res = userService.getOne(queryWrapper);
        if (res==null){
            res = new User();
            res.setPhone(phone);
            res.setStatus(1);
            userService.save(res);
        }
        session.setAttribute("user",res.getId());
        return R.success(res);
    }



}
