package com.intuit.complaintsystem.repositories;

import com.intuit.complaintsystem.model.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseRepository extends JpaRepository<Purchase, String> {
}
