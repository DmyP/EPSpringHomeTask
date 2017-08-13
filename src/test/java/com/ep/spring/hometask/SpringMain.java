package com.ep.spring.hometask;

import com.ep.spring.hometask.domain.User;
import com.ep.spring.hometask.service.UserService;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.Arrays;

public class SpringMain {
    public static void main(String[] args) throws IOException {
        ConfigurableApplicationContext appCtx = new ClassPathXmlApplicationContext("spring.xml");
        System.out.println("Bean definition names: " + Arrays.toString(appCtx.getBeanDefinitionNames()));


        UserService userService = appCtx.getBean(UserService.class);
        userService.getAll().forEach(System.out::println);

        appCtx.close();
    }
}

