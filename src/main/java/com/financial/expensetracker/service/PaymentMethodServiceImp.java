package com.financial.expensetracker.service;

import com.financial.expensetracker.dto.request.PaymentMethodRequest;
import com.financial.expensetracker.dto.response.PaymentMethodResponse;
import com.financial.expensetracker.model.PaymentMethod;
import com.financial.expensetracker.repository.PaymentMethodRepository;
import org.springframework.stereotype.Service;

@Service
public class PaymentMethodServiceImp implements PaymentMethodService {

    private final PaymentMethodRepository paymentMethodRepository;

    public PaymentMethodServiceImp(PaymentMethodRepository paymentMethodRepository) {
        this.paymentMethodRepository = paymentMethodRepository;
    }

    private PaymentMethod createPayment(PaymentMethodRequest paymentMethodRequest) {
        return PaymentMethod.builder()
                .method(paymentMethodRequest.getMethod())
                .build();
    }

    @Override
    public PaymentMethodResponse save(PaymentMethodRequest paymentMethodRequest) {

        PaymentMethod savedPayment = paymentMethodRepository.save(createPayment(paymentMethodRequest));
        return createPaymentMethodResponse(savedPayment);
    }

    private PaymentMethodResponse createPaymentMethodResponse(PaymentMethod thisPayment) {
        return PaymentMethodResponse.builder()
                .paymentMethodId(thisPayment.getPaymentMethodId())
                .method(thisPayment.getMethod())
                .build();
    }
}
