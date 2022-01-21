package com.rohit.project.billing.hospitalbillingmodule.exception;

public class BillNotFoundException extends RuntimeException {
    public BillNotFoundException(String message) {
        super(message);
    }
}
