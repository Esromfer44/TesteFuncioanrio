package Trabalho.Atv03;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static com.jayway.jsonpath.internal.path.PathCompiler.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class Atv03ApplicationTests {

	@Test
	public void testConstrutorValoresValidos() {
		Funcionario f = new Funcionario("João", 30, 20.0);
		assertEquals("João", f.getNome());
		assertEquals(30, f.getHorasTrabalhadas());
		assertEquals(20.0, f.getValorHora(), 0.001);
	}

	@Test
	public void testConstrutorNomeVazio() {
		Funcionario f = new Funcionario("", 30, 20.0);
	}

	@Test
	public void testConstrutorHorasTrabalhadasInvalidas() {
		Funcionario f = new Funcionario("João", 50, 20.0);
	}

	@Test
	public void testConstrutorValorHoraNegativo() {
		Funcionario f = new Funcionario("João", 30, -20.0);
	}

	@Test
	public void testConstrutorValorHoraZero() {
		Funcionario f = new Funcionario("João", 30, 0.0);
	}

	@Test
	public void testSetNomeVazio() {
		Funcionario f = new Funcionario("João", 30, 20.0);
		f.setNome("");
	}

	@Test
	public void testSetHorasTrabalhadasValido() {
		Funcionario f = new Funcionario("João", 30, 20.0);
		f.setHorasTrabalhadas(35);
		assertEquals(35, f.getHorasTrabalhadas());
	}

	@Test
	public void testSetHorasTrabalhadasInvalido() {
		Funcionario f = new Funcionario("João", 30, 20.0);
		f.setHorasTrabalhadas(50);
	}

	@Test
	public void testSetValorHoraValido() {
		Funcionario f = new Funcionario("João", 30, 20.0);
		f.setValorHora(25.0);
		assertEquals(25.0, f.getValorHora(), 0.001);
	}

	@Test
	public void testSetNomeTerceirizadoInvalido() {
		try {
			FuncionarioTerceirizado f = new FuncionarioTerceirizado("", 30, 50.0, 12);
			fail("Deveria ter lançado uma exceção ao inserir um nome inválido");
		} catch (IllegalArgumentException e) {
			assertEquals("O nome não pode ser vazio", e.getMessage());
		}
	}
	@Test
	public void testSetSalarioHoraZero() {
		try {
			Funcionario f = new Funcionario("João", 30, 0);
			fail("Deveria lançar uma exceção ao informar salário hora zero.");
		} catch (IllegalArgumentException e) {
			assertEquals("O valor do salário hora deve ser maior que zero.", e.getMessage());
		}

	}
	@Test
	public void testSetSalarioHoraValido2() {
		Funcionario f = new Funcionario("João", 30, 50.5);
		assertEquals(50.5, f.getValorHora(), 0.001);
	}

	@Test
	public void testSetSalarioHoraValido() {
		Funcionario f = new Funcionario("João", 30, 20);
		assertEquals(20, f.getValorHora(), 0.001);
	}

}

