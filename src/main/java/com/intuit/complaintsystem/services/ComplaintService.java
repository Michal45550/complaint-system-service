package com.intuit.complaintsystem.services;


import com.intuit.complaintsystem.beans.Complaint;
import com.intuit.complaintsystem.dtos.ComplaintCreationDto;

import java.util.concurrent.ExecutionException;

public interface ComplaintService {
    Complaint addComplaint(ComplaintCreationDto complaint) throws InterruptedException, ExecutionException;
}
