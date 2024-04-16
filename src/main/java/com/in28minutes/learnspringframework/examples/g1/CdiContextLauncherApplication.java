package com.in28minutes.learnspringframework.examples.g1;

import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;

//@Component
@Named  // Component 대신 사용 가능
class BusinessService {
    private DataService dataService;

    public DataService getDataService() {
        return dataService;
    }

//    @Autowired
    @Inject // Autowired 대신 사용 가능
    public void setDataService(DataService dataService) {
        System.out.println("Setter Injection");
        this.dataService = dataService;
    }
}

@Component
class DataService {

}

@Configuration
@ComponentScan
public class CdiContextLauncherApplication {
    public static void main(String[] args) {

        try(var context =
                    new AnnotationConfigApplicationContext
                            (CdiContextLauncherApplication.class)) {

            Arrays.stream(context.getBeanDefinitionNames())
                    .forEach(System.out::println);

            System.out.println(context.getBean(BusinessService.class).getDataService());
        }

    }
}
