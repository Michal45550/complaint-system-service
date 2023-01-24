package com.intuit.complaintsystem.services;

import com.intuit.complaintsystem.dtos.PurchaseInfoDto;
import com.intuit.complaintsystem.mappers.ComplaintMapper;
import com.intuit.complaintsystem.repositories.PurchaseRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CompletableFuture;

@Service
public class PurchaseServiceImpl implements PurchaseService {

    private final RestTemplate restTemplate;
    private final PurchaseRepository purchaseRepository;
    private final ComplaintMapper mapper;

    @Value("${craft-mock.url.purchases}")
    String mockUrl;

    public PurchaseServiceImpl(RestTemplateBuilder restTemplateBuilder, PurchaseRepository purchaseRepository, ComplaintMapper mapper) {
        this.restTemplate = restTemplateBuilder.build();
        this.purchaseRepository = purchaseRepository;
        this.mapper = mapper;
    }

    @Override
    @Async
    public CompletableFuture<PurchaseInfoDto> getPurchaseInfo(String purchaseId) {
        String url = String.format(mockUrl, purchaseId);
        PurchaseInfoDto purchaseInfo = restTemplate.getForObject(url, PurchaseInfoDto.class);

        return CompletableFuture.completedFuture(purchaseInfo);
    }

    @Override
    public void savePurchaseInfo(PurchaseInfoDto purchase) {
        purchaseRepository.save(mapper.toPurchase(purchase));
    }

}
