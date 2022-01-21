package com.rohit.project.billing.hospitalbillingmodule.domain;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(unique = true, nullable = false)
    private String patientName;
    @Column(unique = false, nullable = false)
    private LocalDate billDate;
    private String treatment;
    @Column(unique = false, nullable = true)
    private Boolean status;
    @Column(unique = false, nullable = true)
    private Double amount;


}
