package com.gdtico.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gdtico.entity.Employee;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmployeeMapper extends BaseMapper<Employee> {


}
