package com.example.LAB_05.controller;

import com.example.LAB_05.models.applicationRequest;
import com.example.LAB_05.services.ApplicationRequestServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/applicationrequest")
public class ApplicationRequestController {
//    private final ApplicationRequest applicationRequest;
    private final ApplicationRequestServices applicationRequestServices;

    @GetMapping
    public ResponseEntity<?> getApp(){
        List<applicationRequest> tyres =applicationRequestServices.getApp();

        if(tyres.isEmpty()){
            // Если список tyres пустой (а значит таблица шин tyres тоже пустая), то он не будет передаваться в аргументы конструктора ResponseEntity<> (в нем ничего нет), и HTTP-статус будет No Content
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else{
            // Если список tyres содержит данные, то они будет отправлены клиенту. Список tyres будет передаваться в качестве тела ответа. HTTP-статус будет OK (запрос успешно обработан).
            return new ResponseEntity<>(tyres, HttpStatus.OK);
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getApp(@PathVariable(value = "id") Long id){
        applicationRequest tyre = applicationRequestServices.getApplication(id);

        if(Objects.isNull(tyre)){
            // Если в базе данных нет шины с идентификатором, указанным в URL-адресе запроса, то тело ответа будет пустым (отправлять клиенту нечего), а статус будет Not Found
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            // Если в базе данных найдена шина, то ее данные будут отправлены клиенту
            // Объект класса ResponseEntity<> с HTTP-статусом OK можно также создать с помощью статического метода ok(), который принимает тело ответа в качестве аргумента
            // Код ResponseEntity.ok(tyre) эквивалентен коду new ResponseEntity<>(tyre, HttpStatus.OK)
            return ResponseEntity.ok(tyre);
        }
    }

    @PostMapping
    public ResponseEntity<?> addApp(@RequestBody applicationRequest applicationRequest){
        applicationRequest createdTyre = applicationRequestServices.addApplication(applicationRequest);

        // В результате успешного добавления новой шины в базу данных, клиенту будут отправлены данные той самой шины, а HTTP-статус будет Created
        return new ResponseEntity<>(createdTyre, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updateTyre(@PathVariable(value = "id") Long id, @RequestBody applicationRequest applicationRequest){
        applicationRequest updatedTyre = applicationRequestServices.updateTyre(id, applicationRequest);

        if(Objects.isNull(updatedTyre)){
            // Если в базе данных нет шины с идентификатором, указанным в URL-адресе запроса, то тело ответа будет пустым, а статус будет Not Found
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            // В результате успешного обновления данных шины в базе, клиенту будут отправлены обновленные данные той самой шины, а HTTP-статус будет OK
            return ResponseEntity.ok(updatedTyre);
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteApplication(@PathVariable(value = "id") Long id,@RequestBody applicationRequest applicationRequest){
        boolean deleteApplication = applicationRequestServices.deleteApp(id);

        if(deleteApplication){
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}