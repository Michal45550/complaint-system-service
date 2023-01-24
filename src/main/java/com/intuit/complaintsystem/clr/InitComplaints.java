package com.intuit.complaintsystem.clr;

import com.intuit.complaintsystem.dtos.ComplaintCreationDto;
import com.intuit.complaintsystem.services.ComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class InitComplaints implements CommandLineRunner {

    @Autowired
    private ComplaintService complaintService;

    @Override
    public void run(String... args) throws Exception {

        complaintService.addComplaint(ComplaintCreationDto.builder()
                .userId("a872d86a-c7cb-48b7-b5d9-f218d6845405")
                .subject("The seller never sent my item!")
                .complaint("I made a purchase and the item hasn’t shipped. It’s been over a week. Please help!")
                .purchaseId("f256c996-6dcb-40cf-8dce-a11fa9bcab6b")
                .build());

        complaintService.addComplaint(ComplaintCreationDto.builder()
                .userId("a93adc57-4d59-4a9d-85c6-b5d48d99101d")
                .subject("It is not the item I bought")
                .complaint("The item I got is not the one presented in the site!!")
                .purchaseId("21d5dbe2-8369-459d-a955-a6b4f19b4d53")
                .build());

        complaintService.addComplaint(ComplaintCreationDto.builder()
                .userId("a872d86a-c7cb-48b7-b5d9-f218d6845405")
                .subject("The seller never sent my item! #2")
                .complaint("I made a purchase and the item hasn’t shipped. It’s been over a week. Please help!")
                .purchaseId("f256c996-6dcb-40cf-8dce-a11fa9bcab6b")
                .build());

    }
}
