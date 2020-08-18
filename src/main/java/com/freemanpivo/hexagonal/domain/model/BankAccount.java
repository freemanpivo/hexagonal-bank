package com.freemanpivo.hexagonal.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BankAccount {
    private Long register;
    private Long balance; // treating currency as unit

    public boolean withdraw(Long amount) {
        if (balance <= 0) {
            return false;
        }
        this.setBalance(balance - amount);
        return true;
    }

    public void deposit(Long amount) {
        this.setBalance(balance + amount);
    }
}
