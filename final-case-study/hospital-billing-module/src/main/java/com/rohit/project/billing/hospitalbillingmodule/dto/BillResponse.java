package com.rohit.project.billing.hospitalbillingmodule.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class BillResponse<T> {
    private String sts;
    private String msg;
    private T body;
}
