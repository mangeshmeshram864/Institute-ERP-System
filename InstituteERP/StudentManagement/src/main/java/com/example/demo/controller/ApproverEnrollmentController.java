package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ApproveAmountDto;
import com.example.demo.dto.PaymentConfirmDto;
import com.example.demo.dto.RequestAmountDto;
import com.example.demo.interfaces.ApproverEnrollService;

@RestController
@RequestMapping("/approver")
public class ApproverEnrollmentController {

    @Autowired
    private ApproverEnrollService service;


    @PostMapping("/request-amount")
    public ResponseEntity<String> requestAmount(@RequestBody RequestAmountDto dto) {
        return ResponseEntity.ok(service.requestAmount(dto));
    }

   
    @PutMapping("/approve")
    public ResponseEntity<String> approveAmount(@RequestBody ApproveAmountDto dto) {
        return ResponseEntity.ok(service.approveAmount(dto));
    }

 
    @PostMapping("/confirm-payment")
    public ResponseEntity<String> confirmPayment(@RequestBody PaymentConfirmDto dto) {
        return ResponseEntity.ok(service.confirmPayment(dto));
    }
}