package com.petrius.banking_system.domain;

import com.petrius.banking_system.schared.Currency;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RequestCreateAccount {

    @NotBlank(message = "Full name is mandatory")
    String fullName;

    @NotNull(message = "Currency is mandatory")
    Currency currency;
}
