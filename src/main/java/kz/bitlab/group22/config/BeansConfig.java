package kz.bitlab.group22.config;

import kz.bitlab.group22.beans.MyNewBean;
import kz.bitlab.group22.beans.MyNewBeanImpl;
import kz.bitlab.group22.beans.MyNewBeanImplNew;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan(basePackages = {"kz.bitlab.group22"})
public class BeansConfig {

    @Bean
    @Scope("singleton")
    public MyNewBean myNewBean(){
        return new MyNewBeanImpl();
    }

    @Bean
    @Scope("singleton")
    public MyNewBean mySecondBean(){
        return new MyNewBeanImplNew();
    }

}
