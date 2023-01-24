package com.intuit.complaintsystem.dtos;

import lombok.Builder;
import lombok.Data;

import java.sql.Date;
import java.util.UUID;

@Data
@Builder
public class PurchaseInfoDto {

    private UUID id;
    private String userId;
    private String productId;
    private String productName;
    private double pricePaidAmount;
    private String priceCurrency;
    private double discountPercent;
    private String merchantId;
    private Date purchaseDate;
}
