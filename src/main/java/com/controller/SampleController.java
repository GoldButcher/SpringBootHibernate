package com.controller;

import com.CommonResp;
import com.aliyuncs.exceptions.ClientException;
import com.entity.System;
import com.service.MessageService;
import com.service.SystemService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.util.SmsUtil;
import org.springframework.web.bind.annotation.RestController;


@RestController
@EntityScan("com.entity") // 扫描实体类
@EnableJpaRepositories("com.dao") // JPA扫描该包路径下的Repositorie
@EnableTransactionManagement//开启默认事务管理
@SpringBootApplication//spring boot的配置启动容器
@ComponentScan(basePackages={"com"}) // 扫描该包路径下的所有spring组件
@ServletComponentScan//servlet的扫描
@RequestMapping(value = "/sms")
public class SampleController {


    @Autowired
    private SystemService systemService;

    @Autowired
    private MessageService messageService;

    @RequestMapping(value = "/")
    String home(){
        return "Hello Docker World";
    }



    @RequestMapping(value = "/saveSystem")
    String save(System system){
        systemService.save(system);
        return "ok";
    }



    public static void main(String[] args) {
        SpringApplication.run(SampleController.class,"--server.port=9004");
    }


