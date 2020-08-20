package com.freemanpivo.hexagonal.mysql;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "bank_account")
@AllArgsConstructor
@NoArgsConstructor
public class BankAccountEntity {

    @Id
    private Long id;
    private Long balance;
}
