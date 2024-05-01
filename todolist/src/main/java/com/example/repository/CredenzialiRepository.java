package com.example.repository;

import com.example.model.Credenziali;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CredenzialiRepository extends JpaRepository<Credenziali, Long> {

    Credenziali findByUsername(String username);
}
