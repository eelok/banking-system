package com.petrius.banking_system.domain;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RequestAccount {

    @NotBlank(message = "Full name is mandatory")
    String fullName;
    @NotBlank(message = "IBAN is required")
    String iban;
    String currency;

    @NotNull(message = "Balance is required")
    @DecimalMin(value = "0.0", message = "Balance can not be negative ")
    BigDecimal balance;
    BigDecimal withdrawPerDayLimit;
}
