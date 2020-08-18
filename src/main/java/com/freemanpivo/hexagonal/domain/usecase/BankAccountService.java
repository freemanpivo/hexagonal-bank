package com.freemanpivo.hexagonal.domain.usecase;

import com.freemanpivo.hexagonal.domain.model.BankAccount;
import com.freemanpivo.hexagonal.ports.inbound.DepositUseCase;
import com.freemanpivo.hexagonal.ports.inbound.WithdrawUseCase;

public class BankAccountService implements DepositUseCase, WithdrawUseCase {
    @Override
    public void deposit(Long id, Long amount) {
        BankAccount account = new BankAccount(1L, 0L); // refactor to find in DB port
        account.deposit(amount);

        // refactor -> implement save method DB port
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
