package com.intuit.complaintsystem.services;


import com.intuit.complaintsystem.model.User;
import com.intuit.complaintsystem.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
public class UserServiceImpl implements UserService {

    private final RestTemplate restTemplate;
    private final UserRepository userRepository;

    @Value("${craft-mock.url.users}")
    String mockUrl;


    public UserServiceImpl(RestTemplateBuilder restTemplateBuilder, UserRepository userRepository) {
        this.restTemplate = restTemplateBuilder.build();
        this.userRepository = userRepository;
    }

    @Override
    @Async
    public CompletableFuture<User> getUserInfo(UUID userId) {
        String url = String.format(mockUrl, userId.toString());
        User userInfo = restTemplate.getForObject(url, User.class);

        return CompletableFuture.completedFuture(userInfo);
    }

    @Override
    public void saveUserInfo(User user) {
        userRepository.save(user);
    }

}
