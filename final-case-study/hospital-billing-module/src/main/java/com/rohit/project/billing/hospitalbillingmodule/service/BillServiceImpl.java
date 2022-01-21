package com.rohit.project.billing.hospitalbillingmodule.service;

import com.rohit.project.billing.hospitalbillingmodule.domain.Bill;
import com.rohit.project.billing.hospitalbillingmodule.dto.BillDto;
import com.rohit.project.billing.hospitalbillingmodule.exception.AmountNotPaidException;
import com.rohit.project.billing.hospitalbillingmodule.exception.BillNotFoundException;
import com.rohit.project.billing.hospitalbillingmodule.exception.InvalidAmountException;
import com.rohit.project.billing.hospitalbillingmodule.repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Transactional(
        isolation = Isolation.READ_UNCOMMITTED,
        rollbackFor = SQLException.class
)
@Service
public class BillServiceImpl implements BillService {
    @Autowired
    private BillRepository repository;

    @Override
    public BillDto creatingBill(BillDto dto) {
        var bill = new Bill();
        bill.setId(dto.getId());
        bill.setPatientName(dto.getPatientName());
        bill.setBillDate(dto.getBillDate());
        bill.setTreatment(dto.getTreatment());
        bill.setAmount(dto.getAmount());
        bill.setStatus(dto.getStatus());
        repository.save(bill);
        return dto;
    }

    @Override
    public BillDto updateBill(BillDto dto) throws BillNotFoundException {
        Bill bill = repository.findById(dto.getId()).orElse(null);
        var bill1 = new Bill();
        bill1.setId(dto.getId());
        bill1.setPatientName(dto.getPatientName());
        bill1.setBillDate(dto.getBillDate());
        bill1.setTreatment(dto.getTreatment());
        bill1.setAmount(dto.getAmount());
        bill1.setStatus(dto.getStatus());
        repository.save(bill1);
        return dto;
    }

    @Override
    public Boolean billPaid(int id, boolean status) throws InvalidAmountException, AmountNotPaidException {
        if (status = false) throw new AmountNotPaidException("bill not paid");
        Optional<Bill> bi = repository.findById(id);
        Bill oldBill = bi.orElseThrow();
        Boolean exStatus = oldBill.getStatus();
        Boolean newStatus = status;
        Bill newBill = new Bill();
        newBill.setId(oldBill.getId());
        newBill.setPatientName(oldBill.getPatientName());
        newBill.setBillDate(oldBill.getBillDate());
        newBill.setTreatment(oldBill.getTreatment());
        newBill.setAmount(oldBill.getAmount());
        newBill.setStatus(newStatus);
        repository.save(newBill);

        return newBill.getStatus();
    }

    @Override
    public List<BillDto> allBills() {

        List<Bill> bill = repository.findAll();
        List<BillDto> billDto = new ArrayList<>();
        for (int i = 0; i < bill.size(); i++) {
            Bill bills = bill.get(i);

            BillDto dto = new BillDto(
                    bills.getId(),
                    bills.getPatientName(),
                    bills.getBillDate(),
                    bills.getTreatment(),
                    bills.getStatus(),
                    bills.getAmount()
            );
            billDto.add(dto);
        }
        return billDto;
    }

    @Override
    public Bill searchBills(int id) throws InvalidAmountException {
        Bill exBill = repository.search(id);
        if (exBill != null) {
            if (exBill.getAmount() >= 15000) {
                repository.save(exBill);
                return exBill;
            }
        }

        return exBill;
    }
}
