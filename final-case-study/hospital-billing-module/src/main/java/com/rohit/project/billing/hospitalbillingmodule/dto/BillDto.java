package com.rohit.project.billing.hospitalbillingmodule.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.time.LocalDate;

@AllArgsConstructor
@Setter
@Getter
public class BillDto {
    private Integer id;
    private String patientName;
    private LocalDate billDate;
    private String treatment;
    private Boolean status;
    private Double amount;
}
