package com.intuit.complaintsystem.services;


import com.intuit.complaintsystem.dtos.PurchaseInfoDto;

import java.util.concurrent.CompletableFuture;

public interface PurchaseService {
    CompletableFuture<PurchaseInfoDto> getPurchaseInfo(String purchaseId) throws InterruptedException;

    void savePurchaseInfo(PurchaseInfoDto purchase);
}
