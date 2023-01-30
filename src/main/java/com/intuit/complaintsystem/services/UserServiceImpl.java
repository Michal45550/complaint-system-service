package com.intuit.complaintsystem.services;


import com.intuit.complaintsystem.beans.User;
import com.intuit.complaintsystem.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CompletableFuture;

@Service
public class UserServiceImpl implements UserService {

    private final RestTemplate restTemplate;

    @Autowired
    UserRepository userRepository;

    @Value("${craft-mock.url.users}")
    String mockUrl;

    public UserServiceImpl(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    @Override
    @Async
    public CompletableFuture<User> getUserInfo(User user) {
        String url = String.format(mockUrl, user.getId().toString());
        User userInfo = restTemplate.getForObject(url, User.class);

        return CompletableFuture.completedFuture(userInfo);
    }

    @Override
    public void saveUserInfo(User user) {
        userRepository.save(user);
    }

}
