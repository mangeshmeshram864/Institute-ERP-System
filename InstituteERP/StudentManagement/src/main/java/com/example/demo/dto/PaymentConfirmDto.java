package com.example.demo.dto;

import java.time.LocalDate;

public class PaymentConfirmDto {

    private int enrollmentId;
    private Double paymentAmt;
    private String status;
    private LocalDate date;
    private String txId;
    private String name;

	public int getEnrollmentId() {
		return enrollmentId;
	}
	public void setEnrollmentId(int enrollmentId) {
		this.enrollmentId = enrollmentId;
	}
	public Double getPaymentAmt() {
		return paymentAmt;
	}
	public void setPaymentAmt(Double paymentAmt) {
		this.paymentAmt = paymentAmt;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public String getTxId() {
		return txId;
	}
	public void setTxId(String txId) {
		this.txId = txId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	

    
}
