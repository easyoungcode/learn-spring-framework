package com.in28minutes.learnspringframework;

import com.in28minutes.learnspringframework.game.GameRunner;
import com.in28minutes.learnspringframework.game.GamingConsole;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.in28minutes.learnspringframework.game") // ComponentScan을 통해 해당 패키지 안에 있는 Component를 Bean으로 생성
// ComponentScan을 붙여주지 않았을 시 NoSuchBeanDefinitionException 발생
public class App03GamingSpringBean {

    public static void main(String[] args) {

        /** 게임과 GameRunner를 Spring Bean으로 실행
         *  게임과 GameRunner는 Spring Bean,
         *  Spring Context에서 Bean을 가져와 실행함
         * */
        try(var context =
                    new AnnotationConfigApplicationContext
                        (App03GamingSpringBean.class)) {
            context.getBean(GamingConsole.class).up();

            context.getBean(GameRunner.class).run();    // GameRunnerBean을 가져오고 실행시킴
        }

    }

}
