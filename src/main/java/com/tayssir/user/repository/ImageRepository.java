package com.tayssir.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tayssir.user.entity.Image;
public interface ImageRepository extends JpaRepository<Image , Long> {
}

