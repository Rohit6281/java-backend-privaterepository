package com.rohit.project.billing.hospitalbillingmodule.billDto;

import com.rohit.project.billing.hospitalbillingmodule.dto.BillDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BillDtoTests {
    @DisplayName("Testing Object Nullability")
    @Test
    void testInValidObject() {
        BillDto bill = null;
        Assertions.assertNull(bill);
    }

    @DisplayName("BillDto Valid Object")
    @Test
    void testBillDtoValidObject() {
        BillDto bill = new BillDto();
        Assertions.assertNotNull(bill);
    }
}
