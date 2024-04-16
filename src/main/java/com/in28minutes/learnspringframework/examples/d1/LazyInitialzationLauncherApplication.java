package com.in28minutes.learnspringframework.examples.d1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
class ClassA {

}
@Component
@Lazy   // 시작할 때 초기화되지 X, 해당 클래스 Bean을 사용할 때 초기화 됨
class ClassB {
    private ClassA classA;
    public ClassB(ClassA classA) {
        //Logic
        System.out.println("Some Initialization Logic");
        this.classA=classA;
    }

    public void doSomething() {
        System.out.println("Doing Something");
    }
}

@Configuration
@ComponentScan
public class LazyInitialzationLauncherApplication {
    public static void main(String[] args) {

        /** 게임과 GameRunner를 Spring Bean으로 실행
         *  게임과 GameRunner는 Spring Bean,
         *  Spring Context에서 Bean을 가져와 실행함
         * */
        try(var context =
                    new AnnotationConfigApplicationContext
                            (LazyInitialzationLauncherApplication.class)) {
            System.out.println("Initializing LazyInitialzationLauncherApplication");

            context.getBean(ClassB.class).doSomething();
        }
    }
}
