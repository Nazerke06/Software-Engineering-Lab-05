package com.example.LAB_05.repository;

import com.example.LAB_05.models.applicationRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplicationRequestRepository extends JpaRepository<applicationRequest, Long> {
    List<applicationRequest> findByHandled(boolean b);
}
