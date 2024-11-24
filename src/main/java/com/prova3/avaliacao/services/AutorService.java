package com.prova3.avaliacao.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prova3.avaliacao.model.Autor;
import com.prova3.avaliacao.repositories.AutorRepository;

@Service
public class AutorService {

	@Autowired
	private AutorRepository autorRepository;

	public List<Autor> buscarAutores() {
		return autorRepository.findAll();
	}

	public Autor buscarAutorPorId(Long id) {
		Autor autor = autorRepository.findById(id).orElseThrow();

		return autor;
	}

	public Autor inserirAutor(Autor autor) {
		autor.setIdAutor(null);
		autor.setLivros(null);
		return autorRepository.save(autor);
	}

	public Autor alterarAutor(Autor autor) {
		Autor autorAnterior = autorRepository.findById(autor.getIdAutor()).orElseThrow();
		autorAnterior.setNome(autor.getNome());
		autorAnterior.setNacionalidade(autor.getNacionalidade());

		return autorRepository.save(autorAnterior);
	}

	public void deletarAutor(Long id) {
		Autor autor = autorRepository.findById(id).orElseThrow();

		autorRepository.deleteById(autor.getIdAutor());
	}

}
