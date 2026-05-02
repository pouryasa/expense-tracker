package com.financial.expensetracker.controller;

import com.financial.expensetracker.dto.request.PaymentMethodRequest;
import com.financial.expensetracker.dto.response.PaymentMethodResponse;
import com.financial.expensetracker.service.PaymentMethodService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("payment-methods")
public class PaymentMethodController {

    private final PaymentMethodService paymentMethodService;

    public PaymentMethodController(PaymentMethodService paymentMethodService) {
        this.paymentMethodService = paymentMethodService;
    }

    @PostMapping("new-payment")
    public ResponseEntity<PaymentMethodResponse> save(@RequestBody @Valid PaymentMethodRequest paymentMethodRequest) {
        return ResponseEntity.ok(paymentMethodService.save(paymentMethodRequest));
    }
}
