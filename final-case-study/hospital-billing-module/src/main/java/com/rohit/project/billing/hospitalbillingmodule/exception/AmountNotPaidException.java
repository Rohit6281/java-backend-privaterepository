package com.rohit.project.billing.hospitalbillingmodule.exception;

public class AmountNotPaidException extends RuntimeException {
    public AmountNotPaidException(String message) {
        super(message);
    }
}
