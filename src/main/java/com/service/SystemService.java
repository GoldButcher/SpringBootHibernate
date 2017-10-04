package com.service;

import com.dao.SystemDao;
import com.entity.System;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class SystemService {

    @Autowired
    private SystemDao systemDao;

    public void save(System system){
        systemDao.save(system);
    }

    public System findByName(String name){

        return systemDao.findByName(name);
    }
}
