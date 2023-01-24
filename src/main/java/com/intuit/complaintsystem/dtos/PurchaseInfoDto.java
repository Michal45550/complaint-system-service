package com.intuit.complaintsystem.dtos;

import lombok.Builder;
import lombok.Data;

import java.sql.Date;
import java.util.UUID;

@Data
@Builder
public class PurchaseInfoDto {

    private UUID id;
    private UUID userId;
    private UUID productId;
    private String productName;
    private double pricePaidAmount;
    private String priceCurrency;
    private double discountPercent;
    private UUID merchantId;
    private Date purchaseDate;
}
