package com.example.repository;

import com.example.model.Elemento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ElementoRepository extends JpaRepository<Elemento, Long> {
}
