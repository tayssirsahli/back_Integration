package com.tayssir.user.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.tayssir.user.entity.FicheDeDeces;

public interface FicheDecesRepository extends JpaRepository<FicheDeDeces, Long> {
}
