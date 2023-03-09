package com.soa.groupwork3.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "SUBMISSION")
public class Submission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "student_id")
    private int studentId;

    @Column(name = "module_code")
    private String moduleCode;

    @Column(name = "assignment_id")
    private int assignmentId;

    @Column(name = "file_url")
    private String fileUrl;

    @Column(name = "feedback")
    private String feedback;

    public int getId() {
        return id;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getModuleCode() {
        return moduleCode;
    }

    public int getAssignmentId() {
        return assignmentId;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public void setModuleCode(String moduleCode) {
        this.moduleCode = moduleCode;
    }

    public void setAssignmentId(int assignmentId) {
        this.assignmentId = assignmentId;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
}
