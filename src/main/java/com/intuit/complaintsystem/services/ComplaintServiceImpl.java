package com.intuit.complaintsystem.services;

import com.intuit.complaintsystem.beans.Complaint;
import com.intuit.complaintsystem.dtos.ComplaintCreationDto;
import com.intuit.complaintsystem.mappers.ComplaintMapper;
import com.intuit.complaintsystem.repositories.ComplaintRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public class ComplaintServiceImpl implements ComplaintService {

    @Autowired
    ComplaintRepository complaintRepository;

    @Autowired
    ComplaintMapper mapper;

    @Autowired
    AdditionalInfoService additionalInfoService;

    @Override
    public Complaint addComplaint(ComplaintCreationDto complaintCreation) throws ExecutionException, InterruptedException {
        Complaint complaint = complaintRepository.save(mapper.toComplaint(complaintCreation));

        additionalInfoService.saveAdditionalInfo(complaint);

        return complaint;
    }

}
