package com.example.LAB_05.interfaces;


import com.example.LAB_05.models.applicationRequest;

import java.util.List;

public interface ApplicationRequestInterface {
    List<applicationRequest> getApplications();
    applicationRequest addApplication(applicationRequest tyre);
    applicationRequest getApplication(Long id);
    applicationRequest updateApplication(Long id, applicationRequest tyre);
    boolean deleteApplication(Long id);
}
