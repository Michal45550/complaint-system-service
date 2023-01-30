package com.intuit.complaintsystem.services;

import com.intuit.complaintsystem.beans.Complaint;
import com.intuit.complaintsystem.beans.User;
import com.intuit.complaintsystem.dtos.PurchaseInfoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Service
public class AdditionalInfoServiceImpl implements AdditionalInfoService {

    @Autowired
    UserService userService;

    @Autowired
    PurchaseService purchaseService;

    @Override
    @Async
    public void saveAdditionalInfo(Complaint complaint) throws InterruptedException, ExecutionException {

        CompletableFuture<User> userInfo = userService.getUserInfo(complaint.getUser());
        CompletableFuture<PurchaseInfoDto> purchaseInfo = purchaseService.getPurchaseInfo(complaint.getPurchase());
        CompletableFuture.allOf(userInfo).join();

        userService.saveUserInfo(userInfo.get());
        purchaseService.savePurchaseInfo(purchaseInfo.get());
    }
}
