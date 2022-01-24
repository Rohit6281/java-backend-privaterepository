package com.rohit.project.billing.hospitalbillingmodule.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class BillDto {
    private Integer id;

    @NotNull
    @NotBlank
    private String patientName;

    @NotNull
    private LocalDate billDate;

    @NotNull
    private String treatment;

    @NotNull
    private Boolean status;

    @Min(100)
    private Double amount;
}
