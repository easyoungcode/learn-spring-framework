package com.in28minutes.learnspringframework.examples.f1;

import com.in28minutes.learnspringframework.examples.e1.BeanScopeLauncherApplication;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
class SomeClass {
    private SomeDependency someDependency;

    public SomeClass(SomeDependency someDependency) {
        super();
        this.someDependency = someDependency;
        System.out.println("All Dependencies are ready");
    }

    /** @PostConstruct
     *  초기화를 수행하기 위해 의존성 주입이 완료된 후 실행해야 하는 메서드에서 사용되며,
     *  이 메서드는 클래스를 사용하기 전에 호출되어야 한다.
     *  다른 Bean이 이 Bean을 사용할 수 있게 되기 전에 이 메서드가 호출되고 Bean이 로드된다.
     *  */
    @PostConstruct
    public void initialize() {
        someDependency.getReady();
    }

    /** @PreDestroy
     *  Bean이 삭제되기 전에 해야할 일이 있을 경우 사용 (애플리케이션 종료 전) - 예 : DB 연결 해제 등
     *  컨테이너에서 인스턴스를 삭제하는 과정 중에 있음을 알려주는 콜백 알림
     *  보유하고 있던 리소스를 해제하는데 사용됨
     * */
    @PreDestroy
    public void cleanUp() {
        System.out.println("Clean up");
    }
}

@Component
class SomeDependency {
    public void getReady() {
        System.out.println("Some Logic using SomeDependency");
    }
}

@Configuration
@ComponentScan
public class PrePostAnnotationContextLauncherApplication {
    public static void main(String[] args) {

        try(var context =
                    new AnnotationConfigApplicationContext
                            (PrePostAnnotationContextLauncherApplication.class)) {

            Arrays.stream(context.getBeanDefinitionNames())
                    .forEach(System.out::println);
        }

    }
}
