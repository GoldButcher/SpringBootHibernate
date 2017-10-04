package com.dao;

import com.entity.Message;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface MessageDao extends PagingAndSortingRepository<Message,Integer>{

    Message findByPhoneAndContent(String phone,String content);
}
