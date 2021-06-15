package lab14;

import java.io.Serializable;

public class Account implements Serializable {
    private String accountOwner;
    private int accountNo;
    private double balance;

    public Account() {
        this("Null",0,0);
    }
    public Account(String accountOwner,int accountNo, int balance) {
        this.accountOwner = accountOwner;
        this.accountNo = accountNo;
        this.balance = balance;
    }

    public String getAccountOwner() {
        return accountOwner;
    }
    public void setAccountOwner(String accountOwner) {
        this.accountOwner = accountOwner;
    }
    public int getAccountNo() {
        return accountNo;
    }
    public void setAccountNo(int accountNo) {
        this.accountNo = accountNo;
    }
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
}
