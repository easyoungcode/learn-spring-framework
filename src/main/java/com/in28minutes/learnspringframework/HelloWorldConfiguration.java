package com.in28minutes.learnspringframework;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/** record : JDK16부터 추가된 기능, record를 사용하면 생성자, getter, setter 걱정을 없애준다.
 *  getter, setter, 생성자를 입력하지 않아도 사용 가능 */
record Person(String name, int age, Address address) {};
record Address(String firstLine, String city) {};

@Configuration
public class HelloWorldConfiguration {
    /** Bean의 기본이름 = 메서드의 이름 */

    @Bean
    public String name() {
        return "Hello World";
    }

    @Bean
    public int age() {
        return 100;
    }

    @Bean
    public Person person() {
        return new Person("John Doe", 18, new Address("Some Street", "Some City"));
    }

    @Bean
    public Person person2MethodCall() {
        return new Person(name(), age(), address());
    }

    // 메서드를 호출하는 대신 매개변수를 추가하는 형태 (Spring이 관리하는 Bean 가져오는 방법 중 1개)
    @Bean
    public Person person3Parameters(String name, int age, Address address3) { // name, age, address2
        return new Person(name, age, address3);
    }

    @Bean(name = "address2")
    public Address address() {
        return new Address("Baker Street", "London");
    }
    @Bean(name = "address3")
    public Address address3() {
        return new Address("Montana", "Hyderaba");
    }
}
