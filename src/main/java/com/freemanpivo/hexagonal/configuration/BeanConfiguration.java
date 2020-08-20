package com.freemanpivo.hexagonal.configuration;

import com.freemanpivo.hexagonal.domain.usecase.BankAccountService;
import com.freemanpivo.hexagonal.mysql.BankAccountEntityMapper;
import com.freemanpivo.hexagonal.mysql.BankAccountRepository;
import com.freemanpivo.hexagonal.mysql.MySqlService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {
    @Bean
    BankAccountService bankAccountService(MySqlService mysqlService) {
        return new BankAccountService(mysqlService);
    }

    @Bean
    MySqlService databaseService(BankAccountRepository bankAccountRepository, BankAccountEntityMapper mapper) {
        return new MySqlService(bankAccountRepository, mapper);
    }

    @Bean
    BankAccountEntityMapper bankAccountEntityMapper() {
        return new BankAccountEntityMapper();
    }
}
