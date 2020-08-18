package com.freemanpivo.hexagonal.configuration;

import com.freemanpivo.hexagonal.domain.usecase.BankAccountService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {
    @Bean
    BankAccountService bankAccountService() {
        return new BankAccountService();
    }
}
