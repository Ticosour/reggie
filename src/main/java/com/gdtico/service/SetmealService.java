package com.gdtico.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gdtico.dto.SetmealDto;
import com.gdtico.entity.Setmeal;

import java.util.List;

public interface SetmealService extends IService<Setmeal> {
    void saveWithDish(SetmealDto setmealDto);

    void deleteWithDish(List<Long> ids);
}
