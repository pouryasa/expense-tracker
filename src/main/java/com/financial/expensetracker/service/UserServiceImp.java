package com.financial.expensetracker.service;

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


    @Override
    public User save(User user) {
        Optional<User> thisUsername =
                userRepository.findByUsername(user.getUsername());

        if(thisUsername.isPresent()) {
            throw new RuleException("username.is.exist");
        }
        return userRepository.save(user);
    }
}
