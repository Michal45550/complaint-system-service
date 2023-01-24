package com.intuit.complaintsystem.services;

import com.intuit.complaintsystem.dtos.ComplaintCreationDto;
import com.intuit.complaintsystem.dtos.PurchaseInfoDto;
import com.intuit.complaintsystem.mappers.ComplaintMapper;
import com.intuit.complaintsystem.model.User;
import com.intuit.complaintsystem.repositories.ComplaintRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Service
@RequiredArgsConstructor
public class ComplaintServiceImpl implements ComplaintService {

    private final ComplaintRepository complaintRepository;
    private final ComplaintMapper mapper;
    private final UserService userService;
    private final PurchaseService purchaseService;

    @Override
    public void addComplaint(ComplaintCreationDto complaint) throws InterruptedException, ExecutionException {
        complaintRepository.save(mapper.toComplaint(complaint));

        //TODO: Run this AFTER return response
        CompletableFuture<User> userInfo = userService.getUserInfo(complaint.getUserId());
        CompletableFuture<PurchaseInfoDto> purchaseInfo = purchaseService.getPurchaseInfo(complaint.getPurchaseId());
        CompletableFuture.allOf(userInfo).join();

        userService.saveUserInfo(userInfo.get());
        purchaseService.savePurchaseInfo(purchaseInfo.get());
        //TODO: End
    }

}
