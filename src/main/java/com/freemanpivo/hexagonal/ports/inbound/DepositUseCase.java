package com.freemanpivo.hexagonal.ports.inbound;

import java.math.BigDecimal;

public interface DepositUseCase {
    void deposit(BigDecimal amount);
}
