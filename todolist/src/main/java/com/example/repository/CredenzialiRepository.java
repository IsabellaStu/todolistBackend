package com.example.repository;

import com.example.model.Credenziali;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CredenzialiRepository extends JpaRepository<Credenziali, Long> {

    Optional<Credenziali> findByUsername(String username);
    Optional<Credenziali> deleteByUsernameAndPassword(String username, String password);
    Optional<Credenziali> findByPassword(String password);
}