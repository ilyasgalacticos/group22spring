package kz.bitlab.group22.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@ComponentScan(basePackages = {"kz.bitlab.group22"})
public class HibernateConfig {

    @Bean
    public LocalSessionFactoryBean sessionFactory(){

        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
        sessionFactoryBean.setPackagesToScan("kz.bitlab.group22.entities");
        sessionFactoryBean.setDataSource(dataSource());

        Properties property = new Properties();
        property.setProperty("hibernate.hbm2ddl.auto", "update"); //create-drop
        property.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
        property.setProperty("hibernate.show_sql", "true");

        sessionFactoryBean.setHibernateProperties(property);

        return sessionFactoryBean;

    }

    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUsername("root");
        dataSource.setPassword("");
        dataSource.setUrl("jdbc:mysql://localhost:3306/group22_db?serverTimezone=UTC");
        return dataSource;
    }

}
