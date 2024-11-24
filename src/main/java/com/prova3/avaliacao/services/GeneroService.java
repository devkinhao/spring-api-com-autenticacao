package com.prova3.avaliacao.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prova3.avaliacao.model.Genero;
import com.prova3.avaliacao.repositories.GeneroRepository;

@Service
public class GeneroService {

	@Autowired
	private GeneroRepository generoRepository;

	public List<Genero> buscarGeneros() {
		return generoRepository.findAll();
	}

	public Genero buscarGeneroPorId(Long id) {
		Genero genero = generoRepository.findById(id).orElseThrow();

		return genero;
	}

	public Genero inserirGenero(Genero genero) {
		genero.setIdGenero(null);
		genero.setLivros(null);
		return generoRepository.save(genero);
	}

	public Genero alterarGenero(Genero genero) {
		Genero generoAnterior = generoRepository.findById(genero.getIdGenero()).orElseThrow();
		generoAnterior.setDescricao(genero.getDescricao());

		return generoRepository.save(generoAnterior);
	}

	public void deletarGenero(Long id) {
		Genero genero = generoRepository.findById(id).orElseThrow();

		generoRepository.deleteById(genero.getIdGenero());
	}

}
