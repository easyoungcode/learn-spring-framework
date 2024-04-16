package com.in28minutes.learnspringframework.helloworld;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class App02HelloWorldSpring {

    public static void main(String[] args) {
        // Spring이 모든 걸 관리하도록 만들기 -> @Configuration
        // 설정 클래스(@Configuration)을 통해 Spring Context 가능
        try (var context =
                     new AnnotationConfigApplicationContext
                            (HelloWorldConfiguration.class)) {

            //HelloWorldConfiguration - @Configuration
            //name - @Bean
            //Spring이 관리 중인 Bean 검색

            System.out.println(context.getBean("name"));    // Bean은 context.getBean을 사용하고 Bean의 이름을 부여하여 검색 가능
            System.out.println(context.getBean("age"));
            System.out.println(context.getBean("person"));
            System.out.println(context.getBean("person2MethodCall"));
            System.out.println(context.getBean("person3Parameters"));

            // No bean named 'BeanName' available 오류 : Bean 이름과 맞지 않아 발생하는 오류
            System.out.println(context.getBean("address2"));
            /** Spring이 Bean을 관리하기 시작하면 Bean의 이름을 사용하거나 Bean의 유형을 사용해 가져올 수 있다 */
//        System.out.println(context.getBean(Address.class));     // 이름이 아닌 클래스의 이름으로도 가능

            System.out.println(context.getBean("person5PQualifier"));
        }
        /** 관리되는 모든 Bean 이름 출력 */
        /*
        Arrays.stream(context.getBeanDefinitionNames())
                .forEach(System.out::println);
        */
    }

}
