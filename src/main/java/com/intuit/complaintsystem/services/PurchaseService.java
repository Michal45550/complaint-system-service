package com.intuit.complaintsystem.services;


import com.intuit.complaintsystem.beans.Purchase;
import com.intuit.complaintsystem.dtos.PurchaseInfoDto;

import java.util.concurrent.CompletableFuture;

public interface PurchaseService {
    CompletableFuture<PurchaseInfoDto> getPurchaseInfo(Purchase purchase) throws InterruptedException;

    void savePurchaseInfo(PurchaseInfoDto purchase);
}
