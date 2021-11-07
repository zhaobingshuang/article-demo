package me.zhao.validation.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import java.util.Properties;

@Component
public class FailFastConfig implements CommandLineRunner {

    private final LocalValidatorFactoryBean localValidatorFactoryBean;

    public FailFastConfig(LocalValidatorFactoryBean localValidatorFactoryBean) {
        this.localValidatorFactoryBean = localValidatorFactoryBean;
    }

    @Override
    public void run(String... args) throws Exception {
        Properties properties = new Properties();
        properties.setProperty("hibernate.validator.fail_fast", "true");
        localValidatorFactoryBean.setValidationProperties(properties);
        System.out.println("-------------------------");
    }
}
