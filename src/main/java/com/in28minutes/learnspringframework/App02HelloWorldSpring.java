package com.in28minutes.learnspringframework;

import com.in28minutes.learnspringframework.game.GameRunner;
import com.in28minutes.learnspringframework.game.PecmanGame;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class App02HelloWorldSpring {

    public static void main(String[] args) {
        // Spring이 모든 걸 관리하도록 만들기 -> @Configuration
        // 설정 클래스(@Configuration)을 통해 Spring Context 가능
        var context =
                new AnnotationConfigApplicationContext(HelloWorldConfiguration.class);

        //HelloWorldConfiguration - @ Configuration
        //name - @Bean
        //Spring이 관리 중인 Bean 검색
        
        System.out.println(context.getBean("name"));    // Bean은 context.getBean을 사용하고 Bean의 이름을 부여하여 검색 가능
    }

}
