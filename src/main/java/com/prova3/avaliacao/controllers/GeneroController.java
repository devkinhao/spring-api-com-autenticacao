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

import com.prova3.avaliacao.model.Genero;
import com.prova3.avaliacao.services.GeneroService;

@RestController
@RequestMapping("/generos")
public class GeneroController {

	@Autowired
	private GeneroService generoService;

	@GetMapping("")
	public ResponseEntity<List<Genero>> buscarGeneros() {
		return ResponseEntity.ok().body(generoService.buscarGeneros());

	}

	@GetMapping("/{generoId}")
	public ResponseEntity<Genero> buscarGenero(@PathVariable Long generoId) {
		return ResponseEntity.ok().body(generoService.buscarGeneroPorId(generoId));
	}

	@PutMapping("/{generoId}")
	public ResponseEntity<Genero> alterarGenero(@PathVariable Long generoId, @RequestBody Genero genero) {
		genero.setIdGenero(generoId);
		return ResponseEntity.ok().body(generoService.alterarGenero(genero));
	}

	@PostMapping("")
	public ResponseEntity<Genero> inserirGenero(@RequestBody Genero genero) {
		Genero insGenero = generoService.inserirGenero(genero);
		URI vURI = ServletUriComponentsBuilder.fromCurrentRequest().path("/{idGenero}")
				.buildAndExpand(insGenero.getIdGenero()).toUri();
		return ResponseEntity.created(vURI).body(insGenero);
	}

	@DeleteMapping(value = "/{generoId}", produces = "application/json")
	public ResponseEntity<String> deletarGenero(@PathVariable Long generoId) {
		try {
			generoService.deletarGenero(generoId);
			return ResponseEntity
					.ok("{ \"status\" : \"OK\", \"mensagem\" : \"OK\" }");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body("{ \"status\" : \"ERRO\", \"mensagem\" : \"" + e.getMessage() + "\" }");
		}
	}

}
