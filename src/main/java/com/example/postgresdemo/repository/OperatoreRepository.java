package com.example.postgresdemo.repository;

import com.example.postgresdemo.model.Operatore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OperatoreRepository extends JpaRepository<Operatore, Long> {
    List<Operatore> findOperatoreByNome(String nome);
    Optional<Operatore> findOperatoreByIdOperatore(Integer id);
}
