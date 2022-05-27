package com.gdtico.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gdtico.dto.DishDto;
import com.gdtico.entity.Dish;

public interface DishService extends IService<Dish> {
    void saveWithFlavor(DishDto dishDto);

    DishDto getByIdWithFlavor(Long id);


    void updateWithFlavor(DishDto dishDto);
}
