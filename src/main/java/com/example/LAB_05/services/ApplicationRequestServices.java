package com.example.LAB_05.services;
import com.example.LAB_05.models.applicationRequest;
import com.example.LAB_05.repository.ApplicationRequestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor

public class ApplicationRequestServices {

        private final ApplicationRequestRepository applicationRequestRepository;


        public List<applicationRequest> getApp(){
            List<applicationRequest> tyres = applicationRequestRepository.findAll();
            return tyres;
        }

        public applicationRequest addApplication(applicationRequest tyre){
           applicationRequest createdApp = applicationRequest.save(tyre);
            return createdApp;
        }

        public applicationRequest getApplication(Long id){
            applicationRequest app = ApplicationRequestRepository.findById(id).orElse(null);
            return app;
        }

        public applicationRequest updateTyre(Long id, applicationRequest tyre){
            applicationRequest checkTyre = getApplication(id);

            if(Objects.isNull(checkTyre)){
                return null;
            }

            applicationRequest updatedTyre = ApplicationRequestRepository.save(tyre);
            return updatedTyre;
        }


        public boolean deleteApp(Long id){
            applicationRequest checkTyre = getApplication(id);
            if(Objects.isNull(checkTyre)){
                return false;
            }

            ApplicationRequestRepository.deleteById(id);

            return true;
        }
    }
