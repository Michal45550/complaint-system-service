package com.intuit.complaintsystem.repositories;

import com.intuit.complaintsystem.model.Complaint;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComplaintRepository extends JpaRepository<Complaint, Integer> {
}
