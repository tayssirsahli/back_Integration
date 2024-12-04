package com.tayssir.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tayssir.user.entity.Payment;
import com.tayssir.user.repository.PaiementRepository;

@Service
public class PaiementService {
	
	@Autowired
	private  PaiementRepository repository;

   

    public Payment savePaiement(Payment dto) {
       
        return repository.save(dto);
    }

}
