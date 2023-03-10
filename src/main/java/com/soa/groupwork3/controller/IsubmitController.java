package com.soa.groupwork3.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.soa.groupwork3.entity.SubmitRequest;
import com.soa.groupwork3.service.IsubmitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;
import java.util.Objects;

@Controller
public class IsubmitController {
    @Autowired
    private IsubmitService isubmitService;

    @PostMapping("/submit")
    public ResponseEntity<String> makeSubmission(@RequestBody SubmitRequest request) {
        System.out.println(request);
        try {
            if (request.getStudentId() == 0) {
                throw new IllegalArgumentException("please enter valid student id");
            }
            if (request.getAssignment() == null || request.getAssignment().getModuleCode() == ""  || request.getAssignment().getAssignmentId() == 0) {
                throw new IllegalArgumentException("Please enter valid assignment details");
            }
            var res = isubmitService.newSubmission(request.getStudentId(), request.getAssignment(), request.getUrl());
            return ResponseEntity.ok().body(res);
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @GetMapping("/feedback/{subNr}")
    public ResponseEntity<String> getFeedback(@PathVariable Integer subNr) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            var res = isubmitService.getFeedback(subNr);
            return ResponseEntity.ok().body(mapper.writeValueAsString(res));
        } catch (NoSuchElementException ex) {
            return ResponseEntity.badRequest().body("No such record.");
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/module-feedback/{moduleCode}")
    public ResponseEntity<String> getModuleFeedback(@PathVariable String moduleCode) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            var res = isubmitService.getAllFeedbackForModule(moduleCode);
            return ResponseEntity.ok().body(mapper.writeValueAsString(res));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
