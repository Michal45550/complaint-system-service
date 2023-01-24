package com.intuit.complaintsystem.dtos;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class ComplaintCreationDto {

    private UUID userId;
    private String subject;
    private String complaint;
    private UUID purchaseId;

}
