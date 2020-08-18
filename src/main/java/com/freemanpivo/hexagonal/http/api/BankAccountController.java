package com.freemanpivo.hexagonal.http.api;

import com.freemanpivo.hexagonal.ports.inbound.DepositUseCase;
import com.freemanpivo.hexagonal.ports.inbound.WithdrawUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/bank")
@AllArgsConstructor
public class BankAccountController {
    private final DepositUseCase depositUseCase;
    private final WithdrawUseCase withdrawUseCase;
    // private final TransferUseCase transferUseCase;

    @PostMapping(value = "{id}/deposit/{amount}")
    public ResponseEntity depositMoney(@PathVariable final Long id, @PathVariable final Long amount) {
        depositUseCase.deposit(id, amount);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping(value = "{id}/withdraw/{amount}")
    public ResponseEntity withdrawMoney(@PathVariable final Long id, @PathVariable final Long amount) {
        if (withdrawUseCase.withdraw(id, amount)) {
            return new ResponseEntity(HttpStatus.ACCEPTED);
        }
        return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PostMapping(value = "from/{senderId}/value/{moneySent}/to/{receiverId}/value/{moneyReceived}")
    public ResponseEntity transferMoney(
            @PathVariable final Long senderId,
            @PathVariable final BigDecimal moneySent,
            @PathVariable final Long receiverId,
            @PathVariable final BigDecimal moneyReceived) {

        // transferUseCase.transfer(senderId,receiverId,moneySent,moneyReceived);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }

}
