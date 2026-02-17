package com.financial.expensetracker.service;

import com.financial.expensetracker.dto.request.UserRequest;
import com.financial.expensetracker.dto.response.UserResponse;
import com.financial.expensetracker.model.User;

public interface UserService {
    UserResponse save(UserRequest userRequest);
}
