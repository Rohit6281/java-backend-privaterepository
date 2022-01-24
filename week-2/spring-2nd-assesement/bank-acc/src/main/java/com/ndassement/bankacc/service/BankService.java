package com.ndassement.bankacc.service;

import com.ndassement.bankacc.domain.BankAccount;
import com.ndassement.bankacc.exception.InvalidAcNumberException;
import com.ndassement.bankacc.exception.InvalidAmountException;

import java.util.List;

public interface BankService {
    void createNewAccount(BankAccount ba);//done

    BankAccount updateAccountDetails(BankAccount ba);//done

    boolean activateAccount(Long acNum);//done

    boolean deActivateAccount(Long acNum);//done

    double withdraw(Long acNum, double amt) throws InvalidAmountException;//done

    double deposit(Long acNum, double amt) throws InvalidAmountException;//done

    double transferMoney(Long srcAc, Long dstAc, double amt) throws InvalidAmountException;//done error

    BankAccount findAccountByAcNum(Long acNum)throws InvalidAcNumberException;//done

    List<BankAccount> findAllBankAccounts()throws InvalidAcNumberException;//done

    List<BankAccount> namesStartsWith(String prefix);//done
}
