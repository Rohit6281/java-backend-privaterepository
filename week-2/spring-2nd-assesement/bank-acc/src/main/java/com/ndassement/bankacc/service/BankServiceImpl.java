package com.ndassement.bankacc.service;

import com.ndassement.bankacc.domain.BankAccount;
import com.ndassement.bankacc.exception.InvalidAcNumberException;
import com.ndassement.bankacc.exception.InvalidAmountException;
import com.ndassement.bankacc.repository.BankRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Transactional(
        isolation = Isolation.READ_UNCOMMITTED,
        rollbackFor = SQLException.class,
        noRollbackFor = InvalidAmountException.class
)
@Service
public class BankServiceImpl implements BankService {
    private final Logger logger = LoggerFactory.getLogger(BankServiceImpl.class);

    @Autowired
    private BankRepository repository;

    @Override
    public void createNewAccount(BankAccount ba) {
        repository.save(ba);
    }

//    @Override
//    public BankAccount updateAccountDetails(BankAccount ba) {
//        return repository.save(ba);
//    }


    @Override
    public BankAccount updateAccountDetails(BankAccount ba) {
        BankAccount op = repository.findById(ba.getAcNum()).orElse(null);
        op.setAcNum(ba.getAcNum());
        op.setAcHldNm(ba.getAcHldNm());
        op.setStatus(ba.getStatus());
        op.setBalance(ba.getBalance());
        return repository.save(op);
    }

    @Override
    public boolean activateAccount(Long acNum) {
        Optional<BankAccount> op = repository.findById(acNum);

        BankAccount baOld = op.orElseThrow();
        boolean existingstatus = baOld.getStatus();
        boolean newstatus = Boolean.parseBoolean("true");

        BankAccount baNew = new BankAccount();
        baNew.setBalance(baOld.getBalance());
        baNew.setAcCrDt(baOld.getAcCrDt());
        baNew.setStatus(newstatus);
        baNew.setAcHldNm(baOld.getAcHldNm());
        baNew.setAcNum(baOld.getAcNum());

        repository.save(baNew);
        return baNew.getStatus();
    }

    @Override
    public boolean deActivateAccount(Long acNum) {
        Optional<BankAccount> op = repository.findById(acNum);

        BankAccount baOld = op.orElseThrow();
        boolean existingstatus = baOld.getStatus();
        boolean newstatus = Boolean.parseBoolean("false");

        BankAccount baNew = new BankAccount();
        baNew.setBalance(baOld.getBalance());
        baNew.setAcCrDt(baOld.getAcCrDt());
        baNew.setStatus(newstatus);
        baNew.setAcHldNm(baOld.getAcHldNm());
        baNew.setAcNum(baOld.getAcNum());

        repository.save(baNew);
        return baNew.getStatus();
    }

    @Override
    public double withdraw(Long acNum, double amt) {
        if (amt <= 0) throw new InvalidAmountException("Amount Should be Non Zero Positive " + amt);

        Optional<BankAccount> op = repository.findById(acNum);

        BankAccount baOld = op.orElseThrow();
        double existingBalance = baOld.getBalance();
        double newBalance = existingBalance - amt;

        BankAccount baNew = new BankAccount();
        baNew.setBalance(newBalance);
        baNew.setAcCrDt(baOld.getAcCrDt());
        baNew.setStatus(baOld.getStatus());
        baNew.setAcHldNm(baOld.getAcHldNm());
        baNew.setAcNum(baOld.getAcNum());

        repository.save(baNew);
        return baNew.getBalance();
    }


    @Override
    public double deposit(Long acNum, double amt) throws InvalidAmountException {
        if (amt <= 0) throw new InvalidAmountException("Amount Should be Non Zero Positive " + amt);
        Optional<BankAccount> op = repository.findById(acNum);

        BankAccount baOld = op.orElseThrow();
        double existingBalance = baOld.getBalance();
        double newBalance = existingBalance + amt;

        BankAccount baNew = new BankAccount();
        baNew.setBalance(newBalance);
        baNew.setAcCrDt(baOld.getAcCrDt());
        baNew.setStatus(baOld.getStatus());
        baNew.setAcHldNm(baOld.getAcHldNm());
        baNew.setAcNum(baOld.getAcNum());

        repository.save(baNew);

//        withdraw(acNum, 10);

        return baNew.getBalance();

    }

    @Override
    public double transferMoney(Long srcAc, Long dstAc, double amt) {
        if (amt <= 0) throw new InvalidAmountException("Amount Should be Non Zero Positive " + amt);
        BankAccount uSa = new BankAccount();
        uSa.setAcNum(srcAc);
        uSa.setAcHldNm(uSa.getAcHldNm());
        uSa.setAcCrDt(uSa.getAcCrDt());
        uSa.setBalance(uSa.getBalance() - amt);
        uSa.setStatus(uSa.getStatus());

        BankAccount uDa = new BankAccount();
        uDa.setAcNum(dstAc);
        uDa.setAcHldNm(uDa.getAcHldNm());
        uDa.setAcCrDt(uDa.getAcCrDt());
        uDa.setBalance(uDa.getBalance() + amt);
        uDa.setStatus(uDa.getStatus());

        repository.save(uSa);
        repository.save(uDa);

        return 1;
    }

    @Override
    public BankAccount findAccountByAcNum(Long acNum) throws InvalidAcNumberException {
        Optional<BankAccount> op = repository.findById(acNum);

        BankAccount baOld = op.orElseThrow();
//        Long existingacc = baOld.getAcNum();
//        double newacc = ;

//        BankAccount baNew = new BankAccount();
//        baNew.setBalance(baOld.getBalance());
//        baNew.setAcCrDt(baOld.getAcCrDt());
//        baNew.setStatus(baOld.getStatus());
//        baNew.setAcHldNm(baOld.getAcHldNm());
//        baNew.setAcNum(existingacc);

        return repository.save(baOld);
//        return baNew.getAcNum();
    }

    @Override
    public List<BankAccount> findAllBankAccounts() {
        List<BankAccount> op = repository.findAll();
        return op;
    }


    @Override
    public List<BankAccount> namesStartsWith(String prefix) {
        return repository.findByAcHldNmStartingWith(prefix);
    }
}
