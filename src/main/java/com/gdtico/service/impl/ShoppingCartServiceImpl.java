package com.gdtico.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.gdtico.entity.ShoppingCart;
import com.gdtico.mapper.ShoppingCartMapper;
import com.gdtico.service.ShoppingCartService;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartServiceImpl extends ServiceImpl<ShoppingCartMapper, ShoppingCart> implements ShoppingCartService {

}
