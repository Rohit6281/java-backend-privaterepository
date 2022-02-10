package com.rohit.project.billing.hospitalbillingmodule;

import com.rohit.project.billing.hospitalbillingmodule.dto.BillDto;
import com.rohit.project.billing.hospitalbillingmodule.repository.BillRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;

@ExtendWith(SpringExtension.class)
public class ServiceTests {
     @MockBean
    private BillRepository repository;
     @DisplayName("testing Creation Of Bill")
    @Test
     public void testCreateBill(){
         BillDto bill = new BillDto();
         bill.setId(3);
         bill.setPatientName("reddy");
         bill.setBillDate(LocalDate.of(2020 ,6,5));
         bill.setTreatment("covid");
         bill.setStatus(true);
         bill.setAmount(1340.00);
        Assertions.assertEquals(3,bill.getId());
        Assertions.assertEquals("reddy",bill.getPatientName());
        Assertions.assertEquals(LocalDate.of(2020,6,5),bill.getBillDate());
        Assertions.assertEquals(true,bill.getStatus());
        Assertions.assertEquals("covid",bill.getTreatment());
        Assertions.assertEquals(1340.00,bill.getAmount());
     }
     @DisplayName("checking update bill")
     @Test
      public void updateBillTest(){
         BillDto b = new BillDto();
         b.setId(10);
         BillDto bill = new BillDto();
         bill.setId(1);
         bill.setPatientName("reddy");
         bill.setBillDate(LocalDate.of(2020,6,5));
         bill.setTreatment("covid");
         bill.setStatus(true);
         bill.setAmount(20000.00);
         Assertions.assertEquals(1,bill.getId());
      }
    @DisplayName("Testing MarkBills Method")
    @Test
    public void testMarkBill() {
        BillDto bill = new BillDto();
        bill.setStatus(false);
        boolean existStatus = bill.getStatus();
        Assertions.assertEquals(false, existStatus);
    }


}
