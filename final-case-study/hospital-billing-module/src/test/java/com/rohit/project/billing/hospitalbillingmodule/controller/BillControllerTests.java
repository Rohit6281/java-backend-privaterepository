package com.rohit.project.billing.hospitalbillingmodule.controller;

import com.rohit.project.billing.hospitalbillingmodule.dto.BillDto;
import com.rohit.project.billing.hospitalbillingmodule.dto.BillResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BillControllerTests {

    @Autowired
    private TestRestTemplate template;

    @LocalServerPort
    private int port;

    @DisplayName("POST - Bill - Saving Bill Object")
    @Test
    public void testPostMethod() {
        String url = "http://" + "localhost" + ":" + port + "/bill";
        var bill = new BillDto();
        bill.setId(3);
        bill.setPatientName("reddy");
        bill.setTreatment("covid");
        bill.setStatus(true);
        bill.setAmount(20000.00);
        bill.setBillDate(LocalDate.of(2020, 6, 5));
        var re = template.postForEntity(url, bill, BillResponse.class);
        Assertions.assertEquals(HttpStatus.OK, re.getStatusCode());
    }

    @DisplayName("GET - all - Checking Status code")
    @Test
    public void testGetStatusCode() {
        String url = "http://" + "localhost" + ":" + port + "/bill/all";
        ResponseEntity<BillDto> entity = template.getForEntity(url, BillDto.class);
        Assertions.assertEquals(HttpStatus.OK, entity.getStatusCode());

    }
}
