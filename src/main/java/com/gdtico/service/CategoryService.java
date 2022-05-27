package com.gdtico.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gdtico.entity.Category;

public interface CategoryService extends IService<Category> {

    void remove(Long id);
}
