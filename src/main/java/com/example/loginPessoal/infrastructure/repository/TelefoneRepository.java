package com.example.loginPessoal.infrastructure.repository;


import com.example.loginPessoal.infrastructure.model.Telefone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TelefoneRepository extends JpaRepository<Telefone , Long> {
}
