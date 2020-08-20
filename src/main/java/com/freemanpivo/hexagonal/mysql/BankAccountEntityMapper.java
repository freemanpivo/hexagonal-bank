package com.freemanpivo.hexagonal.mysql;

import com.freemanpivo.hexagonal.domain.model.BankAccount;

public class BankAccountEntityMapper {
    public BankAccount toModel(BankAccountEntity entity) {
        return new BankAccount(entity.getId(), entity.getBalance());
    }

    public BankAccountEntity toEntity(BankAccount model) {
        return new BankAccountEntity(model.getAccountNumber(), model.getBalance());
    }
}
