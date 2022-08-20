package com.example.api.web.controller;

import com.example.api.domain.entities.TypeDocument;
import com.example.api.domain.services.TypeDocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/typedocuments")
public class TypeDocumentController {

    @Autowired
    private TypeDocumentService service;

    @GetMapping("/all")
    public ResponseEntity<List<TypeDocument>> getAll(){
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TypeDocument> getTypeDocumentById(@PathVariable("id") int id){
        return service.getTypeDocumentById(id).map(td -> new ResponseEntity<>(td,HttpStatus.OK)).
                orElse(new ResponseEntity<>(null,HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteTypeDocumentById(@PathVariable("id") int id){
        if(service.deleteTypeDocumentById(id) == true){
            return new ResponseEntity<>(true,HttpStatus.OK);
        }else{
            return new ResponseEntity<>(false,HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/save")
    public ResponseEntity<TypeDocument> saveTypeDocument(@RequestBody TypeDocument typeDocument){
        return new ResponseEntity<>(service.saveTypeDocument(typeDocument),HttpStatus.CREATED);
    }

}
