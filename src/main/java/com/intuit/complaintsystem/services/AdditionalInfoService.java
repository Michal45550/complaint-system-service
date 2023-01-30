package com.intuit.complaintsystem.services;


import com.intuit.complaintsystem.beans.Complaint;

import java.util.concurrent.ExecutionException;

public interface AdditionalInfoService {
    void saveAdditionalInfo(Complaint complaint) throws InterruptedException, ExecutionException;

}
