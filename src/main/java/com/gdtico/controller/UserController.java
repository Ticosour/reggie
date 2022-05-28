package com.gdtico.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.gdtico.common.R;
import com.gdtico.entity.User;
import com.gdtico.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Resource
    private UserService userService;

    @Resource
    private RedisTemplate redisTemplate;

    @PostMapping("/sendMsg")
    public R<String> sendMsg(@RequestBody User user){
        String code = "";
        Random random = new Random();
        for (int i=0;i<6;i++){
            code += random.nextInt(10);
        }
        redisTemplate.opsForValue().set(user.getPhone(),code,5, TimeUnit.MINUTES);
        log.info("验证码："+code);
        return R.success("手机验证码已发送 请注意接收");
    }

    @PostMapping("/login")
    public R<User> login(@RequestBody Map user, HttpSession session){
        String phone = user.get("phone").toString();
        String code  = user.get("code").toString();
        System.out.println(phone + "  "+code);
        Object codeInSession = redisTemplate.opsForValue().get(phone);
        System.out.println(codeInSession.toString());
        if (codeInSession!=null && codeInSession.equals(code)) {

            LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.eq(User::getPhone, phone);
            User res = userService.getOne(queryWrapper);
            if (res == null) {
                res = new User();
                res.setPhone(phone);
                res.setStatus(1);
                userService.save(res);
            }
            session.setAttribute("user",res.getId());
            redisTemplate.delete(phone);
            return R.success(res);
        }
        return R.error("登陆失败！验证码错误");
    }


}
