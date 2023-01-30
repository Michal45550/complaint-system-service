package com.intuit.complaintsystem.services;

import com.intuit.complaintsystem.beans.Purchase;
import com.intuit.complaintsystem.dtos.PurchaseInfoDto;
import com.intuit.complaintsystem.mappers.ComplaintMapper;
import com.intuit.complaintsystem.repositories.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CompletableFuture;

@Service
public class PurchaseServiceImpl implements PurchaseService {

    private final RestTemplate restTemplate;

    @Autowired
    PurchaseRepository purchaseRepository;

    @Autowired
    ComplaintMapper mapper;

    @Value("${craft-mock.url.purchases}")
    String mockUrl;

    public PurchaseServiceImpl(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    @Override
    @Async
    public CompletableFuture<PurchaseInfoDto> getPurchaseInfo(Purchase purchase) {
        String url = String.format(mockUrl, purchase.getId().toString());
        PurchaseInfoDto purchaseInfo = restTemplate.getForObject(url, PurchaseInfoDto.class);

        return CompletableFuture.completedFuture(purchaseInfo);
    }

    @Override
    public void savePurchaseInfo(PurchaseInfoDto purchase) {
        purchaseRepository.save(mapper.toPurchase(purchase));
    }

}
