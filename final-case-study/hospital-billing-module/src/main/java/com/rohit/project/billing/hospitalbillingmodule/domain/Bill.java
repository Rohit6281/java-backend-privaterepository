package com.rohit.project.billing.hospitalbillingmodule.domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@Entity
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotBlank
    @NotNull
    @Column(unique = true, nullable = false)
    private String patientName;

    @NotNull
    @Column(unique = false, nullable = false)
    private LocalDate billDate;

    private String treatment;

    @Column(unique = false, nullable = true)
    private Boolean status;

    @Min(100)
    @Column(unique = false, nullable = true)
    private Double amount;


}
