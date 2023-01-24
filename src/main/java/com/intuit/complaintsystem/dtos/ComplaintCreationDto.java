package com.intuit.complaintsystem.dtos;


import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class ComplaintCreationDto {

    private String userId;
    private String subject;
    private String complaint;
    private String purchaseId;

}