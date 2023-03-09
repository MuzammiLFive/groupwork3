package com.soa.groupwork3.model;

public class Feedback {
    private String feedback;
    private String moduleCode;
    private int assignmentId;

    public Feedback(String feedback, String moduleCode, int assignmentId) {
        this.feedback = feedback;
        this.moduleCode = moduleCode;
        this.assignmentId = assignmentId;
    }

    public String getFeedback() {
        return feedback;
    }

    public String getModuleCode() {
        return moduleCode;
    }

    public int getAssignmentId() {
        return assignmentId;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public void setModuleCode(String moduleCode) {
        this.moduleCode = moduleCode;
    }

    public void setAssignmentId(int assignmentId) {
        this.assignmentId = assignmentId;
    }
}
