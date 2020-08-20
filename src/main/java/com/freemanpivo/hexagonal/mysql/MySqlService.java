package com.freemanpivo.hexagonal.mysql;

import com.freemanpivo.hexagonal.domain.model.BankAccount;
import com.freemanpivo.hexagonal.ports.outbound.Datastore;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.NoSuchElementException;
import java.util.Optional;

@AllArgsConstructor
public class MySqlService implements Datastore<BankAccount, Long> {

    private final BankAccountRepository accountRepository;
    private final BankAccountEntityMapper mapper;

    @Override
    public BankAccount save(BankAccount bankAccount) {
        BankAccountEntity accountSaved = accountRepository.save(mapper.toEntity(bankAccount));
        return mapper.toModel(accountSaved);
    }

    @Override
    public Optional<BankAccount> get(Long id) {
        Optional<BankAccountEntity> isEntityPresent = accountRepository.findById(id);
        if (isEntityPresent.isPresent()) {
            return Optional.of(mapper.toModel(isEntityPresent.get()));
        }

        return Optional.empty();
    }
}
