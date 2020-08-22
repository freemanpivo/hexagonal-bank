package com.freemanpivo.hexagonal.domain.usecase;

import com.freemanpivo.hexagonal.domain.model.BankAccount;
import com.freemanpivo.hexagonal.mysql.MySqlService;
import com.freemanpivo.hexagonal.ports.inbound.DepositUseCase;
import com.freemanpivo.hexagonal.ports.inbound.WithdrawUseCase;
import com.freemanpivo.hexagonal.ports.outbound.Datastore;
import lombok.AllArgsConstructor;

import java.util.NoSuchElementException;
import java.util.Optional;

@AllArgsConstructor
public class BankAccountService implements DepositUseCase, WithdrawUseCase {

    private final Datastore<BankAccount, Long> datastore;

    @Override
    public void deposit(Long id, Long amount) {
        Optional<BankAccount> account = datastore.get(id);
        if (account.isPresent()) {
            account.get().deposit(amount);
            datastore.save(account.get());
            return;
        }
        throw new NoSuchElementException("Bank Account not found");
    }

    @Override
    public boolean withdraw(Long id, Long amount) {
        BankAccount account = new BankAccount(1L, 0L);

        boolean hasWithdrawn = account.withdraw(amount);
        if (hasWithdrawn) {
            // update DB Port
        }
        return hasWithdrawn;
    }
}
