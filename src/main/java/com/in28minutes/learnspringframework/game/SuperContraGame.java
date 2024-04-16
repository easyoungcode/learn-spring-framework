package com.in28minutes.learnspringframework.game;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("SuperContraGameQualifier")  // Autowiring 시, 필드나 매개변수에서 후보 Bean에 대한 한정자로 쓰임
public class SuperContraGame implements GamingConsole{
    public void up() {
        System.out.println("Jump");
    }
    public void down() {
        System.out.println("sit Down");
    }
    public void left() {
        System.out.println("Go back");
    }
    public void right() {
        System.out.println("shoot a bullet");
    }
}
