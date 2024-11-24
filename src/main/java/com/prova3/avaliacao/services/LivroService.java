package com.prova3.avaliacao.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prova3.avaliacao.model.Livro;
import com.prova3.avaliacao.repositories.LivroRepository;

@Service
public class LivroService {

	@Autowired
	private LivroRepository livroRepository;

	public List<Livro> buscarLivros() {
		return livroRepository.findAll();
	}

	public Livro buscarLivroPorId(Long id) {
		Livro livro = livroRepository.findById(id).orElseThrow();

		return livro;
	}

	public Livro inserirLivro(Livro livro) {
		livro.setIdLivro(null);
		return livroRepository.save(livro);
	}

	public Livro alterarLivro(Livro livro) {
		Livro livroAnterior = livroRepository.findById(livro.getIdLivro()).orElseThrow();
		livroAnterior.setTitulo(livro.getTitulo());
		livroAnterior.setAnoPublicacao(livro.getAnoPublicacao());
		livroAnterior.setAutor(livro.getAutor());
		livroAnterior.setGenero(livro.getGenero());

		return livroRepository.save(livroAnterior);
	}

	public void deletarLivro(Long id) {
		Livro livro = livroRepository.findById(id).orElseThrow();

		livroRepository.deleteById(livro.getIdLivro());
	}

}
