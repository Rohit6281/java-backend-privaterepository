package com.rohit.project.billing.hospitalbillingmodule;

import com.rohit.project.billing.hospitalbillingmodule.controller.BillController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HospitalBillingModuleApplicationTests {
    @Autowired
    private BillController controller;
    @Test
    void contextLoads() {
        Assertions.assertNotNull(controller);
    }

}
