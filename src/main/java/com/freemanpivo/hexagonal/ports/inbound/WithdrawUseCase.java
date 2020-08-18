package com.freemanpivo.hexagonal.ports.inbound;

import java.math.BigDecimal;

public interface WithdrawUseCase {
    boolean withdraw(Long id, Long amount);
}
