package com.gdtico.controller;

import com.gdtico.common.R;
import com.gdtico.entity.Orders;
import com.gdtico.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 订单
 */
@Slf4j
@RestController
@RequestMapping("/order")
public class OrderController {
        @Resource
        private OrderService orderService;

        @PostMapping("/submit")
        public R<String> submit(@RequestBody Orders orders){
            orderService.submit(orders);
            return R.success("下单成功");
        }
}