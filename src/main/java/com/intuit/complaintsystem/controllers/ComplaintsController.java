package com.intuit.complaintsystem.controllers;

import com.intuit.complaintsystem.dtos.ComplaintCreationDto;
import com.intuit.complaintsystem.services.ComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("api/complaints-system")
public class ComplaintsController {

    @Autowired
    private ComplaintService service;

    @PostMapping
    public ResponseEntity<?> addComplaint(@RequestBody ComplaintCreationDto complaint) throws ExecutionException, InterruptedException {
        return new ResponseEntity<>(service.addComplaint(complaint).getId(), HttpStatus.OK);
    }
}
