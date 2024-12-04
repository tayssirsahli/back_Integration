package com.tayssir.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tayssir.user.entity.FicheDeDeces;
import com.tayssir.user.repository.FicheDecesRepository;

@Service
public class FicheDecesService {
	
	@Autowired
	private  FicheDecesRepository repository;

    

    public FicheDeDeces saveFicheDeces(FicheDeDeces ficheDeces ) {
      
        return repository.save(ficheDeces);
    }

}
