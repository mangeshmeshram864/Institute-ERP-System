package com.example.demo.interfaces;

import com.example.demo.dto.ApproveAmountDto;
import com.example.demo.dto.PaymentConfirmDto;
import com.example.demo.dto.RequestAmountDto;

public interface ApproverEnrollService {

	 String requestAmount(RequestAmountDto dto);

	 String approveAmount(ApproveAmountDto dto);

	 String confirmPayment(PaymentConfirmDto dto);
}
