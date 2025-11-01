package com.example.LAB_05;

import com.example.LAB_05.entity.Operators;
import com.example.LAB_05.repository.OperatorRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OperatorDataInitializer {

    @Autowired
    private OperatorRepository operatorRepository;

    @PostConstruct
    public void init() {
        if (operatorRepository.count() == 0) {
            operatorRepository.save(new Operators(null, "Aigerim", "Tleubayeva", "IT", null));
            operatorRepository.save(new Operators(null, "Nurlan", "Kairatov", "Marketing", null));
            operatorRepository.save(new Operators(null, "Dana", "Saparova", "Support", null));
            operatorRepository.save(new Operators(null, "Miras", "Beketov", "PR", null));
        }
    }
}
