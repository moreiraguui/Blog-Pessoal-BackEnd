package com.generation.blogPessoal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.blogPessoal.model.Postagem;
import com.generation.blogPessoal.repository.PostagemRepository;

@RestController
@RequestMapping("/postagens")
@CrossOrigin(origins = "*", allowedHeaders = "*") // "*" vai aceitar a classe de qualquer origin
public class PostagemController {
	 
	@Autowired // Injeção de independência para o Spring
	private PostagemRepository repositoty;																					
	
	@GetMapping //Quando você jogar localhost:8080/postagens ele mostra todos os dados
	public ResponseEntity<List<Postagem>> getAll() {
		return ResponseEntity.ok(repositoty.findAll());
	}
	
	@GetMapping("/{id}") //Pesquisar no postman pelo id, no caso pelo id 1
	public ResponseEntity<Postagem> getById(@PathVariable long id) {  //Quando queremos passar um valor pela URI (URL),
		return repositoty.findById(id)
				.map(resp -> ResponseEntity.ok(resp)) 		//.map tem a função de evitar o erro
				.orElse(ResponseEntity.notFound().build());
			
	}
	
	@GetMapping("/titulo/{titulo}") //Pesquisar no postman pelo titulo
	public ResponseEntity<List<Postagem>> getByTitulo(@PathVariable String titulo) {
		return ResponseEntity.ok(repositoty.findAllByTituloContainingIgnoreCase(titulo));
				
	}
	
	@PostMapping //Inserir dados atraves do postman, Body >>> raw >>> JSON
	public ResponseEntity<Postagem> post (@RequestBody Postagem postagem){
		return ResponseEntity.status(HttpStatus.CREATED).body(repositoty.save(postagem));
		
//		@RequestBody Para Recepcionar os valores/objetos que são passadas via body para nossa aplicação,
	}
	
	@PutMapping //Inserir atualização.
	public ResponseEntity<Postagem> put (@RequestBody Postagem postagem){
		return ResponseEntity.status(HttpStatus.OK).body(repositoty.save(postagem));
	}
	
	@DeleteMapping("/{id}")// Apagar um dado no postman.
	public void delete (@PathVariable long id) {  	// como é void, nao necessita do return
		repositoty.deleteById(id);
	}
 }
