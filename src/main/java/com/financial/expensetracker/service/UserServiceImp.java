package com.financial.expensetracker.service;

import com.financial.expensetracker.dto.request.UserRequest;
import com.financial.expensetracker.dto.response.UserResponse;
import com.financial.expensetracker.exception.RuleException;
import com.financial.expensetracker.model.User;
import com.financial.expensetracker.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImp implements UserService {

    private final UserRepository userRepository;

    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    private User createUser(UserRequest userRequest) {
        return User.builder()
                .password(userRequest.getPassword())
                .username(userRequest.getUsername())
                .email(userRequest.getEmail())
                .currency(userRequest.getCurrency())
                .build();
    }

    @Override
    public UserResponse save(UserRequest userRequest) {
        Optional<User> thisUsername = userRepository.findByUsername(userRequest.getUsername());

        if (thisUsername.isPresent()) {
            throw new RuleException("username.is.exist");
        } else {
            return createUserResponse(userRepository.save(createUser(userRequest)));
        }
    }

    private UserResponse createUserResponse(User thisUser) {
        return UserResponse.builder()
                .id(thisUser.getUserId())
                .username(thisUser.getUsername())
                .build();
    }

}
