package com.petrius.banking_system.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class IbanGeneratorTest {

    private IbanGenerator ibanGenerator;

    @BeforeEach
    void setUp(){
        ibanGenerator = new IbanGenerator();
    }

    @Test
    void shouldGenerateIbanWithCorrectLength_22(){
        assertEquals(22, ibanGenerator.generateIban().length());
    }

    @Test
    void shouldStartWithDE(){
        String iban = ibanGenerator.generateIban();

        assertTrue(iban.startsWith("DE"));
    }

    @Test
    void shouldGenerateDifferentIban(){
        String iban1 = ibanGenerator.generateIban();
        String iban2 = ibanGenerator.generateIban();

        assertNotEquals(iban1, iban2);
    }

}
