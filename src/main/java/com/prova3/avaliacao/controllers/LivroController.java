package com.prova3.avaliacao.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.prova3.avaliacao.model.Livro;
import com.prova3.avaliacao.services.LivroService;

@RestController
@RequestMapping("/livros")
public class LivroController {

	@Autowired
	private LivroService livroService;

	@GetMapping("")
	public ResponseEntity<List<Livro>> buscarLivros() {
		return ResponseEntity.ok().body(livroService.buscarLivros());

	}

	@GetMapping("/{livroId}")
	public ResponseEntity<Livro> buscarLivro(@PathVariable Long livroId) {
		return ResponseEntity.ok().body(livroService.buscarLivroPorId(livroId));
	}

	@PutMapping("/{livroId}")
	public ResponseEntity<Livro> alterarLivro(@PathVariable Long livroId, @RequestBody Livro livro) {
		livro.setIdLivro(livroId);
		return ResponseEntity.ok().body(livroService.alterarLivro(livro));
	}

	@PostMapping("")
	public ResponseEntity<Livro> inserirLivro(@RequestBody Livro livro) {
		Livro insLivro = livroService.inserirLivro(livro);
		URI vURI = ServletUriComponentsBuilder.fromCurrentRequest().path("/{idLivro}")
				.buildAndExpand(insLivro.getIdLivro()).toUri();
		return ResponseEntity.created(vURI).body(insLivro);
	}

	@DeleteMapping(value = "/{livroId}", produces = "application/json")
	public ResponseEntity<String> deletarLivro(@PathVariable Long livroId) {
		try {
			livroService.deletarLivro(livroId);
			return ResponseEntity
					.ok("{ \"status\" : \"OK\", \"mensagem\" : \"OK\" }");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body("{ \"status\" : \"ERRO\", \"mensagem\" : \"" + e.getMessage() + "\" }");
		}
	}

}
