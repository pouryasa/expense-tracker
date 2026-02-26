package com.financial.expensetracker.service;

import com.financial.expensetracker.dto.request.UserRequest;
import com.financial.expensetracker.dto.response.UserResponse;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    UserResponse save(UserRequest userRequest);
}
