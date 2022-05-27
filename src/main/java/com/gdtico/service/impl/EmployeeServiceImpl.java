package com.gdtico.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gdtico.entity.Employee;
import com.gdtico.mapper.EmployeeMapper;
import com.gdtico.service.EmployeeService;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService{



}
