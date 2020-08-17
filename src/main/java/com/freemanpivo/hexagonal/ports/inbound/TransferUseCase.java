package com.freemanpivo.hexagonal.ports.inbound;

import java.math.BigDecimal;

public interface TransferUseCase {
    void transfer(Long from, Long to, BigDecimal moneySent, BigDecimal moneyReceived);
}
