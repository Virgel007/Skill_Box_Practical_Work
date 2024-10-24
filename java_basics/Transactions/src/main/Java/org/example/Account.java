package org.example;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class Account {
    private long money;

    private String accNumber;

    private boolean accBlock;
    public Account(long money, String accNumber) {
        this.money = money;
        this.accNumber = accNumber;
    }

    public Account(long money, String accNumber, boolean accBlock) {
        this.money = money;
        this.accNumber = accNumber;
        this.accBlock = accBlock;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(accNumber, account.accNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accNumber);
    }
}
