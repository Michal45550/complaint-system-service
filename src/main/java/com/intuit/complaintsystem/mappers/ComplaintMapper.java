package com.intuit.complaintsystem.mappers;

import com.intuit.complaintsystem.beans.Complaint;
import com.intuit.complaintsystem.beans.Purchase;
import com.intuit.complaintsystem.beans.User;
import com.intuit.complaintsystem.dtos.ComplaintCreationDto;
import com.intuit.complaintsystem.dtos.PurchaseInfoDto;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ComplaintMapper {

    public Complaint toComplaint(ComplaintCreationDto complaint) {
        return Complaint.builder()
                .id(UUID.randomUUID())
                .user(User.builder().id(complaint.getUserId()).build())
                .subject(complaint.getSubject())
                .complaint(complaint.getComplaint())
                .purchase(Purchase.builder().id(complaint.getPurchaseId()).build())
                .build();

    }

    public Purchase toPurchase(PurchaseInfoDto purchase) {
        return Purchase.builder()
                .id(purchase.getId())
                .user(User.builder().id(purchase.getUserId()).build())
                .productId(purchase.getProductId())
                .productName(purchase.getProductName())
                .pricePaidAmount(purchase.getPricePaidAmount())
                .priceCurrency(purchase.getPriceCurrency())
                .discountPercent(purchase.getDiscountPercent())
                .merchantId(purchase.getMerchantId())
                .purchaseDate(purchase.getPurchaseDate())
                .build();

    }

}
