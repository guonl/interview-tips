package aop.demo6;

import aop.Greeting;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 6. Spring AOP：前置增强 + 后置增强（声明式）
 */
public class Client1 {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("aop/demo6/spring1.xml");
        Greeting greeting = (Greeting) context.getBean("greetingProxy");
        greeting.sayHello("Jack");
    }
}
