package cn.zhangxd.platform.system.provider.beanpostprocessor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanPostProcessorTest {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("beanpostprocessor.xml");
        DemoService demoService=(DemoService) context.getBean("demoService");
        demoService.sayHello();
    }
}