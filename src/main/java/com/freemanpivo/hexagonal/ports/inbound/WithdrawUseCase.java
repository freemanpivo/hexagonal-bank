package com.freemanpivo.hexagonal.ports.inbound;

import java.math.BigDecimal;

public interface WithdrawUseCase {
    void withdraw(BigDecimal amount);
}