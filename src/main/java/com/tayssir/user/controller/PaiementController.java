package com.tayssir.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.tayssir.user.entity.Payment;
import com.tayssir.user.service.PaiementService;

@RestController
@RequestMapping("/api/paiements")
@CrossOrigin(origins = "*")
public class PaiementController {
	
	@Autowired
	private  PaiementService service;

   

    @PostMapping
    public ResponseEntity<Payment> savePaiement(@RequestBody Payment paiementDTO) {
    	Payment savedPaiement = service.savePaiement(paiementDTO);
        return ResponseEntity.ok(savedPaiement);
    }

}
