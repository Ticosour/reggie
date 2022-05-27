package com.gdtico.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gdtico.entity.DishFlavor;
import com.gdtico.mapper.DishFlavorMapper;
import com.gdtico.service.DishFlavorService;
import org.springframework.stereotype.Service;

@Service
public class DishFlavorServiceImpl extends ServiceImpl<DishFlavorMapper, DishFlavor>implements DishFlavorService {
}
