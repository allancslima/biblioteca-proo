package br.edu.ifal.biblioteca.bo;

import org.junit.Test;

import br.edu.ifal.biblioteca.model.Aluno;
import br.edu.ifal.biblioteca.model.Biblioteca;
import br.edu.ifal.biblioteca.model.LivroDidatico;
import br.edu.ifal.biblioteca.model.LivroParadidatico;
import br.edu.ifal.biblioteca.model.Locacao;
import br.edu.ifal.biblioteca.model.Material;
import br.edu.ifal.biblioteca.model.Pessoa;
import br.edu.ifal.biblioteca.model.Professor;
import junit.framework.TestCase;

public class BibliotecaBOTest extends TestCase {
	
	private BibliotecaBO bibliotecaBO;
	
	@Override
	protected void setUp() throws Exception {
		bibliotecaBO = new BibliotecaBO(new Biblioteca());
	}
	
	@Test
	public void testNaoDeveriaValidarCadastroMaterial () throws Exception {
		Material material = new LivroDidatico();
		material.setTitulo("tit");
		
		try {
			bibliotecaBO.validarCadastroMaterial(material, 0);
		} catch (Exception e) {
			assertEquals("Cadastro inválido", e.getMessage());
			assertEquals(0, bibliotecaBO.getQuantidadeMaterial(material));
		}
	}
	
	@Test
	public void testDeveriaValidarCadastroMaterial () throws Exception {
		Material material = new LivroDidatico();
		material.setTitulo("titulo");
		material.setEditora("editora");
		material.setAno(2017);
		
		try {
			bibliotecaBO.validarCadastroMaterial(material, 10);
			assertEquals(10, bibliotecaBO.getQuantidadeMaterial(material));
		} catch (Exception e) {
			assertEquals("", e.getMessage());
		}
	}
	
	@Test
	public void testNaoDeveriaAdicionarLocacoes () throws Exception {
		Material material = new LivroParadidatico();
		material.setTitulo("titulo");
		material.setEditora("editora");
		material.setAno(2017);
		Pessoa pessoa = new Professor();
		
		Locacao locacao = new Locacao();
		locacao.setMaterial(material);
		locacao.setPessoa(pessoa);
		
		try {
			bibliotecaBO.validarCadastroMaterial(material, 1);
			bibliotecaBO.adicionarLocacao(locacao);
			bibliotecaBO.adicionarLocacao(locacao);
		} catch (Exception e) {
			assertEquals("Estoque insuficiente", e.getMessage());
			assertEquals(0, bibliotecaBO.getQuantidadeMaterial(material));
		}
	}
	
	@Test
	public void testDeveriaAdicionarLocacoes () throws Exception {
		Material material = new LivroDidatico();
		material.setTitulo("titulo");
		material.setEditora("editora");
		material.setAno(2017);
		Pessoa pessoa = new Aluno();
		
		Locacao locacao = new Locacao();
		locacao.setMaterial(material);
		locacao.setPessoa(pessoa);
		
		try {
			bibliotecaBO.validarCadastroMaterial(material, 10);
			bibliotecaBO.adicionarLocacao(locacao);
			assertEquals(9, bibliotecaBO.getQuantidadeMaterial(material));
		} catch (Exception e) {
			assertEquals("", e.getMessage());
		}
	}
}