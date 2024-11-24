package com.prova3.avaliacao.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "LIVRO")
public class Livro implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idLivro;

	@ManyToOne
	@JoinColumn(name = "id_autor", nullable = false)
	private Autor autor;

	@ManyToOne
	@JoinColumn(name = "id_genero", nullable = false)
	private Genero genero;

	private String titulo;
	private Integer anoPublicacao;

	public Livro() {
	}

	public Livro(Long idLivro, Autor autor, Genero genero, String titulo, Integer anoPublicacao) {
		this.idLivro = idLivro;
		this.autor = autor;
		this.genero = genero;
		this.titulo = titulo;
		this.anoPublicacao = anoPublicacao;
	}

	public Long getIdLivro() {
		return idLivro;
	}

	public void setIdLivro(Long idLivro) {
		this.idLivro = idLivro;
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Integer getAnoPublicacao() {
		return anoPublicacao;
	}

	public void setAnoPublicacao(Integer anoPublicacao) {
		this.anoPublicacao = anoPublicacao;
	}

}
