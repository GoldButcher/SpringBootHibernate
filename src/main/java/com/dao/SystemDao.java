package com.dao;

import com.entity.System;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SystemDao extends PagingAndSortingRepository<System,Integer> {
        System findByName(String name);
}
