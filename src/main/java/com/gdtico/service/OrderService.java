package com.gdtico.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gdtico.entity.Orders;


public interface OrderService extends IService<Orders> {
        void submit(Orders orders);
}
