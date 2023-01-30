package com.intuit.complaintsystem.services;


import com.intuit.complaintsystem.beans.User;

import java.util.concurrent.CompletableFuture;

public interface UserService {
    CompletableFuture<User> getUserInfo(User user) throws InterruptedException;

    void saveUserInfo(User user);
}
