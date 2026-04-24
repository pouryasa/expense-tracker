package com.financial.expensetracker.service;

import com.financial.expensetracker.dto.request.PaymentMethodRequest;
import com.financial.expensetracker.dto.response.PaymentMethodResponse;
import org.springframework.stereotype.Service;

@Service
public interface PaymentMethodService {
    PaymentMethodResponse save(PaymentMethodRequest paymentMethodRequest);
}
