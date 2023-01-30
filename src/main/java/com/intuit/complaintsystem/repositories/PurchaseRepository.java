package com.intuit.complaintsystem.repositories;

import com.intuit.complaintsystem.beans.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseRepository extends JpaRepository<Purchase, String> {
}
