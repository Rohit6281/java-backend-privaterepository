package com.rohit.project.billing.hospitalbillingmodule.bill;

import com.rohit.project.billing.hospitalbillingmodule.domain.Bill;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BillTests {
    @DisplayName("Testing Object Nullability")
    @Test
    void testInValidObject() {
        Bill bill = null;
        Assertions.assertNull(bill);
    }
        @DisplayName("Bill Valid Object")
        @Test
        void testBillValidObject() {
            Bill bill = new Bill();
            Assertions.assertNotNull(bill);
        }
    @DisplayName("Domain : Checking getters and setters")
    @Test
    void testObjectGettersSetters() {
        var abc = new Bill();
        abc.setId(3);
        abc.setPatientName("reddy");
        abc.setTreatment("covid");
        abc.setAmount( 20000.00);
        abc.setStatus(true);
        abc.getPatientName();

        Assertions.assertEquals(3, abc.getId());
        Assertions.assertEquals("reddy" , abc.getPatientName());
        Assertions.assertEquals(20000.00,abc.getAmount());
        Assertions.assertEquals(true,abc.getStatus());
        Assertions.assertEquals(
                ("covid")
                , abc.getTreatment()
        );
    }
}
