package com.soa.groupwork3.repository;

import com.soa.groupwork3.entity.Submission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubmissionRepository extends JpaRepository<Submission, Long> {

    Submission getById(Integer id);

    List<Submission> getAllByModuleCode(String id);
}
