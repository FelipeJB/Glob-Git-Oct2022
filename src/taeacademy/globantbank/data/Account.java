package org.globantbank.data;

import java.time.LocalDate;

public class Account {

    int accountNumber;
    LocalDate openingDate = LocalDate.now();
    float accountBalance = 0;

    Account(int number){
        this.accountNumber = number;
    }

    
}
