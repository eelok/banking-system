package com.petrius.banking_system.domain;

import com.petrius.banking_system.schared.Currency;
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
    Currency currency;
    BigDecimal balance;
    BigDecimal withdrawPerDayLimit;
}
