package com.petrius.banking_system.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Account {

    //@GeneratedValue(strategy = GenerationType.IDENTITY) => Database macht auto increment (1, 2, 3...)
    //@GeneratedValue(strategy = GenerationType.SEQUENCE) => @GeneratedValue(strategy = GenerationType.SEQUENCE)
    //@GeneratedValue(strategy = GenerationType.TABLE)

    @Id
    @GeneratedValue //default strategy bedeutet AUTO -> Spring Hibirnate entscheidet automatish
    Long id;
    String fullName;
    String iban;
    String currency;
    BigDecimal balance;
    BigDecimal withdrawPerDayLimit;

//    // Alle Transfers wo ICH der Sender bin
//    @OneToMany(mappedBy = "senderAccount")
//    List<Transfer> outgoingTransfers;
//
//    // Alle Transfers wo ICH der Empfänger bin
//    @OneToMany(mappedBy = "recipientAccount")
//    List<Transfer> incomingTransfers;
}
