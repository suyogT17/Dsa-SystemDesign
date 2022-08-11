package com.designpattern.facade;

public class BankAccountAccessTest {
    public static void main(String[] args) {
        BankAccessFacade bankAccessFacade = new BankAccessFacade(123456, 1234);
        bankAccessFacade.withdraw(100.0);
        bankAccessFacade.deposit(100.0);
    }
}

class BankAccessFacade {
    int accountNumber;
    int code;
    AccountChecker accountChecker;
    FundChecker fundChecker;
    SecurityCodeChecker securityCodeChecker;
    WelcomeBank welcomeBank;

    public BankAccessFacade(int accountNumber, int code){
        this.accountNumber = accountNumber;
        this.code = code;

        this.welcomeBank = new WelcomeBank();
        this.accountChecker = new AccountChecker();
        this.fundChecker = new FundChecker();
        this.securityCodeChecker = new SecurityCodeChecker();
    }

    public void withdraw(double amount){
        if(accountChecker.verifyAccount(accountNumber) && securityCodeChecker.verifySecurityCode(code) && fundChecker.decramentBalance(amount)){
            System.out.println("Transaction Completed");
        }
        else System.out.println("Transaction Failed");
    }

    public void deposit(double amount){
        if(accountChecker.verifyAccount(accountNumber) && securityCodeChecker.verifySecurityCode(code)){
            fundChecker.increamentBalance(amount);
            System.out.println("Transaction Completed");
        }
        else System.out.println("Transaction Failed");
    }
}

class AccountChecker {
    int accountNumber = 123456;

    boolean verifyAccount(int accountNumber) {
        if (this.accountNumber != accountNumber) {
            System.out.println("Invalid account number");
            return false;
        }
        return true;
    }
}

class FundChecker {
    double balance = 1000.00;

    boolean checkSufficientFunds(double value) {
        if (balance < value) {

            return false;
        }
        return true;
    }

    void increamentBalance(double value) {
        balance += value;
        System.out.println("Deposit Successful. Balanced : " + balance);

    }

    boolean decramentBalance(double value) {
        if (checkSufficientFunds(value)) {
            balance -= value;
            System.out.println("Withdrawal Successful. Balanced : " + balance);
            return true;
        }
        return false;
    }
}

class SecurityCodeChecker {
    int code = 1234;

    boolean verifySecurityCode(int securityCode) {
        if (this.code != securityCode) {
            System.out.println("Invalid security code");
            return false;
        }
        return true;
    }
}

class WelcomeBank {
    public WelcomeBank() {
        System.out.println("Welcome to ABC Bank");
    }
}
