package com.soa.groupwork3.entity;

import com.soa.groupwork3.model.Assignment;

public class SubmitRequest {
    private int studentId;
    private Assignment assignment;
    private String url;

    public int getStudentId() {
        return studentId;
    }

    public Assignment getAssignment() {
        return assignment;
    }

    public String getUrl() {
        return url;
    }
}
