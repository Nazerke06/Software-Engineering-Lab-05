package com.example.LAB_05.controller;


import com.example.LAB_05.entity.Operators;
import com.example.LAB_05.services.OperatorsServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/operators")
public class OperatorsController {

    private final OperatorsServices operatorsServices;

    @GetMapping
    public ResponseEntity<?> getOperators(){
        List<Operators> operators=operatorsServices.getOperator();

        if(operators.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else {
            return new ResponseEntity<>(operators, HttpStatus.OK);
        }
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getOperators(@PathVariable (value="id") Long id){
        Operators operators =operatorsServices.getOperatorsId(id);

        if (Objects.isNull(operators)){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else{
             new ResponseEntity<>(operators, HttpStatus.OK);
             return ResponseEntity.ok(operators);
        }
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updateOperators(@PathVariable (value="id") Long id, @RequestBody Operators operators){
        Operators updateOperators=operatorsServices.getOperatorsId(id);

        if (Objects.isNull(updateOperators)){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else{
            new ResponseEntity<>(operators, HttpStatus.OK);
            return ResponseEntity.ok(updateOperators);
        }

    }

    @DeleteMapping(value ="/{id}")
    public ResponseEntity<?> deleteOperators(@PathVariable (value="id") Long id){
        boolean deleteOperators= operatorsServices.deleteOperators(id);
        if (deleteOperators){
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
