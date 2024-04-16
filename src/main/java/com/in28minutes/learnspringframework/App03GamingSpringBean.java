package com.in28minutes.learnspringframework;

import com.in28minutes.learnspringframework.game.GameRunner;
import com.in28minutes.learnspringframework.game.GamingConsole;
import com.in28minutes.learnspringframework.game.PecmanGame;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class App03GamingSpringBean {

    public static void main(String[] args) {

        /** 게임과 GameRunner를 Spring Bean으로 실행
         *  게임과 GameRunner는 Spring Bean,
         *  Spring Context에서 Bean을 가져와 실행함
         * */
        try(var context = new AnnotationConfigApplicationContext
                (GamingConfiguration.class)) {
            context.getBean(GamingConsole.class).up();

            context.getBean(GameRunner.class).run();    // GameRunnerBean을 가져오고 실행시킴
        }

    }

}
