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

import com.prova3.avaliacao.model.Autor;
import com.prova3.avaliacao.services.AutorService;

@RestController
@RequestMapping("/autores")
public class AutorController {

	@Autowired
	private AutorService autorService;

	@GetMapping("")
	public ResponseEntity<List<Autor>> buscarAutores() {
		return ResponseEntity.ok().body(autorService.buscarAutores());

	}

	@GetMapping("/{autorId}")
	public ResponseEntity<Autor> buscarAutor(@PathVariable Long autorId) {
		return ResponseEntity.ok().body(autorService.buscarAutorPorId(autorId));
	}

	@PutMapping("/{autorId}")
	public ResponseEntity<Autor> alterarAutor(@PathVariable Long autorId, @RequestBody Autor autor) {
		autor.setIdAutor(autorId);
		return ResponseEntity.ok().body(autorService.alterarAutor(autor));
	}

	@PostMapping("")
	public ResponseEntity<Autor> inserirAutor(@RequestBody Autor autor) {
		Autor insAutor = autorService.inserirAutor(autor);
		URI vURI = ServletUriComponentsBuilder.fromCurrentRequest().path("/{idAutor}")
				.buildAndExpand(insAutor.getIdAutor()).toUri();
		return ResponseEntity.created(vURI).body(insAutor);
	}

	@DeleteMapping(value = "/{autorId}", produces = "application/json")
	public ResponseEntity<String> deletarAutor(@PathVariable Long autorId) {
		try {
			autorService.deletarAutor(autorId);
			return ResponseEntity
					.ok("{ \"status\" : \"OK\", \"mensagem\" : \"OK\" }");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body("{ \"status\" : \"ERRO\", \"mensagem\" : \"" + e.getMessage() + "\" }");
		}
	}

}
