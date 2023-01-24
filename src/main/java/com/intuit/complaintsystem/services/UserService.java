package com.intuit.complaintsystem.services;


import com.intuit.complaintsystem.model.User;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

public interface UserService {
    CompletableFuture<User> getUserInfo(UUID userId) throws InterruptedException;

    void saveUserInfo(User user);
}
