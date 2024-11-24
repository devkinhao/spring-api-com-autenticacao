package com.prova3.avaliacao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prova3.avaliacao.model.Autor;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {

}
