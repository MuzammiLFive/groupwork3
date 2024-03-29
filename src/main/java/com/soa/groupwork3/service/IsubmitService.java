package com.soa.groupwork3.service;

import com.soa.groupwork3.entity.Submission;
import com.soa.groupwork3.model.Assignment;
import com.soa.groupwork3.model.Feedback;
import com.soa.groupwork3.repository.SubmissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.FileAlreadyExistsException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class IsubmitService {
    @Autowired
    private SubmissionRepository submissionRepository;

    public String newSubmission(int studentId, Assignment assignment, String url) throws FileAlreadyExistsException {
        var existingRecord = submissionRepository.getByFileUrl(url);
        if (existingRecord != null) {
            throw new FileAlreadyExistsException("File already submitted");
        }

        var newRecord = new Submission();
        System.out.println(newRecord.getId());
        newRecord.setFileUrl(url);
        newRecord.setAssignmentId(assignment.getAssignmentId());
        newRecord.setModuleCode(assignment.getModuleCode());
        newRecord.setStudentId(studentId);
        newRecord.setFeedback("");

        var sub = submissionRepository.save(newRecord);
        return Integer.toString(sub.getId());
    }

    public Feedback getFeedback(Integer subNr) {
        var submitted = submissionRepository.getById(subNr);
        if (submitted == null) {
            throw new NoSuchElementException();
        }
        return new Feedback(submitted.getFeedback(), submitted.getModuleCode(), submitted.getAssignmentId());
    }

    public List<Feedback> getAllFeedbackForModule(String moduleCode, int studentId) {
        var records = submissionRepository.getAllByModuleCodeAndStudentId(moduleCode, studentId);
        return records.stream().map(x -> new Feedback(x.getFeedback(), x.getModuleCode(), x.getAssignmentId()))
                .collect(Collectors.toList());
    }
}
