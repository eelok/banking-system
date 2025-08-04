package com.petrius.banking_system.service;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class IbanGenerator {

   public String generateIban(){
       Random random = new Random();
       int upperBound = 10;
       String iban = "";
       while (iban.length() < 20){
           iban += String.valueOf(random.nextInt(upperBound));
       }
       return String.format("DE%s", iban);
   }
}
