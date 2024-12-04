package com.tayssir.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tayssir.user.entity.Payment;

public interface PaiementRepository extends JpaRepository<Payment, Long> {
}