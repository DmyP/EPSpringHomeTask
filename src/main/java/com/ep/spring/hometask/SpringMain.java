package com.ep.spring.hometask;

import com.ep.spring.hometask.repository.UserRepository;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.Arrays;

public class SpringMain {
    public static void main(String[] args) throws IOException {
        ConfigurableApplicationContext appCtx = new ClassPathXmlApplicationContext("spring.xml");
        System.out.println("Bean definition names: " + Arrays.toString(appCtx.getBeanDefinitionNames()));

        UserRepository userRepository = appCtx.getBean(UserRepository.class);
        userRepository.getAll();
        appCtx.close();
    }
}

