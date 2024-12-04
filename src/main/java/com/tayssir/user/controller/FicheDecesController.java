package com.tayssir.user.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.tayssir.user.entity.FicheDeDeces;
import com.tayssir.user.service.FicheDecesService;

@RestController
@RequestMapping("/api/fiches-deces")
@CrossOrigin(origins = "*")
public class FicheDecesController {
	
	@Autowired
	private FicheDecesService service;

    

    @PostMapping
    public ResponseEntity<FicheDeDeces> saveFicheDeces(@RequestBody FicheDeDeces ficheDeces) {
    	service.saveFicheDeces(ficheDeces);
        return ResponseEntity.ok(ficheDeces);
    }

}
