package com.intuit.complaintsystem.services;


import com.intuit.complaintsystem.dtos.PurchaseInfoDto;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

public interface PurchaseService {
    CompletableFuture<PurchaseInfoDto> getPurchaseInfo(UUID purchaseId) throws InterruptedException;

    void savePurchaseInfo(PurchaseInfoDto purchase);
}
