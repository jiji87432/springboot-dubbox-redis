package cn.zhangxd.platform.system.provider.beanpostprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * 针对继承了接口的bean，注入name
 *
 * @author lenovo
 * @time 2016年4月21日
 */
//@Configuration
public class NameBeanPostProcessor implements BeanPostProcessor {
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof NameInit) {
            ((NameInit) bean).setName(name);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

}