package com.petrius.banking_system.domain;

import jakarta.validation.constraints.NotBlank;
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

    @NotBlank(message = "Currency is mandatory")
    String currency;
}
