package com.petrius.banking_system.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseAccount {
    Long id;
    String fullName;
    String iban;
    String currency;
    BigDecimal balance;
    BigDecimal withdrawPerDayLimit;
}
