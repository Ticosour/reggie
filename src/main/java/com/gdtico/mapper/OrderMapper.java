package com.gdtico.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gdtico.entity.Orders;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper extends BaseMapper<Orders> {

}