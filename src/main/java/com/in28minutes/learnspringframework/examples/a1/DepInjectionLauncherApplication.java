package com.in28minutes.learnspringframework.examples.a1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;

// 생성자, Setter, Autowired를 통해 YourBusinessClass에 Dependency1, Dependency2 주입
@Component
class YourBusinessClass {

    Dependency1 dependency1;
    Dependency2 dependency2;

    // 생성자 주입
    public YourBusinessClass(Dependency1 dependency1, Dependency2 dependency2) {
        super();
        System.out.println("Constructing YourBusinessClass");
        this.dependency1 = dependency1;
        this.dependency2 = dependency2;
    }

    public String toString() {
        return "Using "+ dependency1+" and "+dependency2;
    }

/*  Setter 주입  
    @Autowired
    public void setDependency1(Dependency1 dependency1) {
        System.out.println("Setting dependency1 to "+dependency1);
        this.dependency1 = dependency1;
    }
    @Autowired
    public void setDependency2(Dependency2 dependency2) {
        System.out.println("Setting dependency2 to "+dependency2);
        this.dependency2 = dependency2;
    }*/
}
@Component
class Dependency1 {

}
@Component
class Dependency2 {

}


@Configuration
// 만약 @ComponentScan만 있다면, 스캔되는 대상은 현재 패키지가 된다.
@ComponentScan
public class DepInjectionLauncherApplication {
    public static void main(String[] args) {

        try(var context =
                    new AnnotationConfigApplicationContext
                            (DepInjectionLauncherApplication.class)) {
            Arrays.stream(context.getBeanDefinitionNames())
                    .forEach(System.out::println);

            System.out.println(context.getBean(YourBusinessClass.class));
        }

    }
}
