package com.in28minutes.learnspringframework.examples.a0;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
@ComponentScan("com.in28minutes.learnspringframework.examples.a0")
public class SimpleSpringContextLauncherApplication {
    public static void main(String[] args) {

        /** 게임과 GameRunner를 Spring Bean으로 실행
         *  게임과 GameRunner는 Spring Bean,
         *  Spring Context에서 Bean을 가져와 실행함
         * */
        try(var context =
                    new AnnotationConfigApplicationContext
                            (SimpleSpringContextLauncherApplication.class)) {
            Arrays.stream(context.getBeanDefinitionNames())
                    .forEach(System.out::println);
        }

    }
}
