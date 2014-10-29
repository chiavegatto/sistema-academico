package br.com.academico;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import br.com.academico.Aluno;

public class AlunoTest {
    Aluno aluno;
	
	@Before
	public void iniciar(){
		aluno = new Aluno();
	}
	
	@Test
	public void alunoReprovadoPorNota(){
		aluno.setNota1(2.0);
		aluno.setNota2(2.0);
		aluno.setNota3(2.0);
		aluno.gerarMedia();
		assertEquals("Reprovado", aluno.getStatus());
	}
	
	@Test
	public void alunoAprovadoMedia7(){
		aluno.setNota1(7.0);
		aluno.setNota2(7.0);
		aluno.setNota3(7.0);
		aluno.gerarMedia();
		assertEquals("Aprovado", aluno.getStatus());
	}
	
	@Test
	public void alunoAprovadoMediaMaiorQue7(){
		aluno.setNota1(8.0);
		aluno.setNota2(8.0);
		aluno.setNota3(8.0);
		aluno.gerarMedia();
		assertEquals("Aprovado", aluno.getStatus());
	}
	
	@Test
	public void alunoEmProvaFinal(){
		aluno.setNota1(4.0);
		aluno.setNota2(4.0);
		aluno.setNota3(4.0);
		aluno.gerarMedia();
		assertEquals("Prova Final", aluno.getStatus());
	}
	
	@Test
	public void alunoReprovadoProvaFinal(){
		aluno.setNota1(4.0);
		aluno.setNota2(4.0);
		aluno.setNota3(4.0);
		aluno.gerarMedia();
		assertEquals("Prova Final", aluno.getStatus());
		aluno.setProvaFinal(2.0);
		assertEquals("Reprovado Prova Final", aluno.getStatus());
	}
	
	@Test
	public void alunoAprovadoProvaFinal(){
		aluno.setNota1(4.0);
		aluno.setNota2(4.0);
		aluno.setNota3(4.0);
		aluno.gerarMedia();
		assertEquals("Prova Final", aluno.getStatus());
		aluno.setProvaFinal(6.0);
		assertEquals("Aprovado Prova Final", aluno.getStatus());
	}
	
	@Test
	public void testGetAndSet(){
		aluno.setNota1(4.0);
		aluno.setNota2(5.0);
		aluno.setNota3(3.0);
		assertEquals(4.0, aluno.getNota1(), 0.001);
		assertEquals(5.0, aluno.getNota2(), 0.001);
		assertEquals(3.0, aluno.getNota3(), 0.001);
		aluno.gerarMedia();
		assertEquals(4.0, aluno.getMedia(), 0.001);
	}
	/*	
	@Test
	public void alunoAprovadoProvaFinalOpcional(){
		aluno.setNota1(7.0);
		aluno.setNota2(7.0);
		aluno.setNota3(7.0);
		aluno.gerarMedia();
		aluno.setProvaFinal(2.0);
		assertEquals("Aprovado", aluno.getStatus());
	}
	
	@Test
	public void alunoReprovadoProvaFinalOpcional(){
		aluno.setNota1(2.0);
		aluno.setNota2(1.0);
		aluno.setNota3(0.0);
		aluno.gerarMedia();
		aluno.setProvaFinal(2.0);
		assertEquals("Reprovado", aluno.getStatus());
	}
	
	//Matador de mutante
	@Test
	public void matarMutante(){
		aluno.setNota1(6.0);
		aluno.setNota2(6.0);
		aluno.setNota3(6.0);
		aluno.gerarMedia();
		aluno.setProvaFinal(2.0);
		assertEquals("Reprovado Prova Final", aluno.getStatus());
	}*/
}
