package com.in28minutes.learnspringframework.game;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary    // Bean에게 우선권 부여, @Component가 여러 개인 경우 해당 Bean을 가장 우선적으로 실행
public class MarioGame implements GamingConsole{
    public void up() {
        System.out.println("Jump");
    }
    public void down() {
        System.out.println("Go into a hole");
    }
    public void left() {
        System.out.println("Go back");
    }
    public void right() {
        System.out.println("accelerate");
    }
}
