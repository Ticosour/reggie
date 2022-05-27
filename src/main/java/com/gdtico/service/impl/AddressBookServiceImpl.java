package com.gdtico.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gdtico.entity.AddressBook;
import com.gdtico.mapper.AddressBookMapper;
import com.gdtico.service.AddressBookService;
import org.springframework.stereotype.Service;

@Service
public class AddressBookServiceImpl extends ServiceImpl<AddressBookMapper, AddressBook> implements AddressBookService {

}
