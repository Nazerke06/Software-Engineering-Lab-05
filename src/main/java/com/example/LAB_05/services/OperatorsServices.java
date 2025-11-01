package com.example.LAB_05.services;

import com.example.LAB_05.entity.Operators;
import com.example.LAB_05.repository.OperatorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
@Service
@RequiredArgsConstructor

public class OperatorsServices {
    private final OperatorRepository operatorRepository;

    public List<Operators> getOperator(){
        List<Operators> operators = operatorRepository.findAll();
        return operators;
    }


    public Operators addOperator(Operators courses){
        Operators createdTyre = operatorRepository.save(courses);
        return createdTyre;
    }

        public Operators getOperatorsId(Long id){
        Operators operators =operatorRepository.findById(id).orElse(null);
        return operators;
    }


    public Operators updatedOperators(Long id, Operators tyre){
        Operators checkOperators = getOperatorsId(id);

        if(Objects.isNull(checkOperators)){
            return null;
        }
        Operators updatedOperators =operatorRepository.save(tyre);
        return updatedOperators;
    }

    public boolean deleteOperators(Long id){
        Operators checkOperators = getOperatorsId(id);

        if(Objects.isNull(checkOperators)){
            return false;
        }
        operatorRepository.deleteById(id);

        return true;
    }
}
