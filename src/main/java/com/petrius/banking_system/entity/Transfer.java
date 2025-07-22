package com.petrius.banking_system.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Transfer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    LocalDateTime dateTime;
    BigDecimal amount;
    String message;
    Status status;

    @ManyToOne
    @JoinColumn(name= "senderAccountId")
    Account senderAccount;

    @ManyToOne
    @JoinColumn(name = "recipientAccountId")
    Account recipientAccount;

}
