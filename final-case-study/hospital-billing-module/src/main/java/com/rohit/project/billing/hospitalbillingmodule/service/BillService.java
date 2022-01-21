package com.rohit.project.billing.hospitalbillingmodule.service;

import com.rohit.project.billing.hospitalbillingmodule.domain.Bill;
import com.rohit.project.billing.hospitalbillingmodule.dto.BillDto;
import com.rohit.project.billing.hospitalbillingmodule.exception.AmountNotPaidException;
import com.rohit.project.billing.hospitalbillingmodule.exception.BillNotFoundException;
import com.rohit.project.billing.hospitalbillingmodule.exception.InvalidAmountException;

import java.util.List;

public interface BillService {
    BillDto creatingBill(BillDto dto);

    BillDto updateBill(BillDto dto) throws BillNotFoundException;

    Boolean billPaid(int id, boolean status) throws AmountNotPaidException;

    List<BillDto> allBills();

    Bill searchBills(int id) throws InvalidAmountException;
}
