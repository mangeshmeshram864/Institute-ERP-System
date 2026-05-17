package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ApproveAmountDto;
import com.example.demo.dto.PaymentConfirmDto;
import com.example.demo.dto.RequestAmountDto;
import com.example.demo.entity.Enrollment;
import com.example.demo.interfaces.ApproverEnrollService;
import com.example.demo.repository.EnrollmentRepository;

@Service
public class ApproverEnrollServiceImpl implements ApproverEnrollService {

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    // Request Amount
    @Override
    public String requestAmount(RequestAmountDto dto) {

        Enrollment enrol = enrollmentRepository.findById(dto.getEnrollmentId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        enrol.setReqFees(dto.getAmount());
        enrol.setApproved(false);   

        enrollmentRepository.save(enrol);

        return "Request amount saved";
    }

    // Approve Amount (NO MONEY UPDATE)
    @Override
    public String approveAmount(ApproveAmountDto dto) {

        Enrollment enrol = enrollmentRepository.findById(dto.getEnrollmentId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        enrol.setApproved(true);

        enrollmentRepository.save(enrol);

        return "Amount approved successfully";
    }

    // Confirm Payment (FINAL UPDATE)
    @Override
    public String confirmPayment(PaymentConfirmDto dto) {

        Enrollment enrol = enrollmentRepository.findById(dto.getEnrollmentId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        // check approved first
        if (Boolean.FALSE.equals(enrol.getApproved())) {
            return "Payment not allowed, not approved";
        }

        Double paid = enrol.getPaidFees() == null ? 0.0 : enrol.getPaidFees();

        enrol.setPaidFees(paid + dto.getPaymentAmt());

        // update remaining fees
        enrol.setRemainigFees(enrol.getTotalFees() - enrol.getPaidFees());

        // clear request
        enrol.setReqFees(0.0);

        enrollmentRepository.save(enrol);

        return "Payment confirmed successfully";
    }
}