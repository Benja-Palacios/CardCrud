package com.crud.card.CardCrud.controller;

import com.crud.card.CardCrud.model.Card;
import com.crud.card.CardCrud.model.ServiceResponse;
import com.crud.card.CardCrud.service.ICardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/v1/card")
@CrossOrigin("*")
public class CardController {
    @Autowired
    private ICardService iCardService;

    @GetMapping("/list")
    public ResponseEntity<List<Card>> list(){
        var result = iCardService.findAll();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<ServiceResponse> save(@RequestBody Card card){
        ServiceResponse serviceResponse = new ServiceResponse();
        int result = iCardService.save(card);
        if(result == 1){
            serviceResponse.setMessage("Guardado Correctamente");
        }
        return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<ServiceResponse> update(@RequestBody Card card){
        ServiceResponse serviceResponse = new ServiceResponse();
        int result = iCardService.update(card);
        if(result == 1){
            serviceResponse.setMessage("Actualizado Correctamente");
        }
        return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ServiceResponse> delete(@PathVariable int id){
        ServiceResponse serviceResponse = new ServiceResponse();
        int result = iCardService.deleteById(id);
        if(result == 1){
            serviceResponse.setMessage("Eliminado Correctamente");
        }
        return new ResponseEntity<>(serviceResponse, HttpStatus.OK);
    }
}
