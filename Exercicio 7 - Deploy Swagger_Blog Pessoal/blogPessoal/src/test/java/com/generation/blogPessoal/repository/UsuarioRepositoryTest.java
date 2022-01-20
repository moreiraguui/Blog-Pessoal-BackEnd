package com.generation.blogPessoal.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.generation.blogPessoal.model.Usuario;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UsuarioRepositoryTest {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@BeforeAll
    void start(){

        usuarioRepository.save(new Usuario(0L, "Joao Victor Generation", "joao@joao.com.br", "1234567"));

        usuarioRepository.save(new Usuario(0L, "Guilherme Maromba Generation", "gui@gui.com.br", "1234567"));

        usuarioRepository.save(new Usuario(0L, "Jhonatan Filosofo Generation", "jhon@jhon.com.br", "1234567"));

        usuarioRepository.save(new Usuario(0L, "Melquizedck", "melqui@melqui.com.br", "1234567"));
    }
	
	@Test
	@DisplayName("Retorna 1 usuario")
	public void deveRetornarUmUsuario() {
		
		Optional<Usuario> usuario = usuarioRepository.findByUsuario("gui@gui.com.br");
		assertTrue(usuario.get().getUsuario().equals("gui@gui.com.br"));
	}
	
	@Test
	@DisplayName("Retorna 3usuario")
	public void deveRetornarTresUsuario() {
		
		List<Usuario> listaDeUsuarios = usuarioRepository.findAllByNomeContainingIgnoreCase("Generation");
		assertEquals(3, listaDeUsuarios.size());
		assertTrue(listaDeUsuarios.get(0).getNome().equals("Joao Victor Generation"));
		assertTrue(listaDeUsuarios.get(1).getNome().equals("Guilherme Maromba Generation"));
		assertTrue(listaDeUsuarios.get(2).getNome().equals("Jhonatan Filosofo Generation"));
	}
	

}
