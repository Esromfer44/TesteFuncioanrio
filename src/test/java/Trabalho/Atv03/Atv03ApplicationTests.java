package Trabalho.Atv03;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class Atv03ApplicationTests {

	@Test
	public void testConstrutor() {
		Funcionario funcionario = new Funcionario("João", 40, 50.0);
		assertEquals("João", funcionario.getNome());
		assertEquals(40, funcionario.getHorasTrabalhadas());
		assertEquals(50.0, funcionario.getValorHora(), 0.001);
	}

	@Test
	public void testSetNome() {
		Funcionario funcionario = new Funcionario("João", 40, 50.0);
		funcionario.setNome("José");
		assertEquals("José", funcionario.getNome());
	}

	@Test
	public void testSetHorasTrabalhadas() {
		Funcionario funcionario = new Funcionario("João", 40, 50.0);
		funcionario.setHorasTrabalhadas(35);
		assertEquals(35, funcionario.getHorasTrabalhadas());
	}

	@Test
	public void testSetHorasTrabalhadasAcimaDoLimite() {
		Funcionario funcionario = new Funcionario("João", 40, 50.0);
		funcionario.setHorasTrabalhadas(50);
		assertEquals(40, funcionario.getHorasTrabalhadas());
	}

	@Test
	public void testSetValorHora() {
		Funcionario funcionario = new Funcionario("João", 40, 50.0);
		funcionario.setValorHora(60.0);
		assertEquals(60.0, funcionario.getValorHora(), 0.001);
	}

	@Test
	public void testSetValorHoraAbaixoDoLimite() {
		Funcionario funcionario = new Funcionario("João", 40, 50.0);
		funcionario.setValorHora(40.0);
		assertEquals(52.8, funcionario.getValorHora(), 0.001);
	}

	@Test
	public void testSetValorHoraAcimaDoLimite() {
		Funcionario funcionario = new Funcionario("João", 40, 50.0);
		funcionario.setValorHora(70.0);
		assertEquals(70.0, funcionario.getValorHora(), 0.001);
	}

	@Test
	public void testCalculaPagamento() {
		Funcionario funcionario = new Funcionario("João", 40, 50.0);
		assertEquals(2000.0, funcionario.calculaPagamento(), 0.001);
	}

	@Test
	public void testCalculaPagamentoAbaixoDoSalarioMinimo() {
		Funcionario funcionario = new Funcionario("João", 30, 30.0);
		assertEquals(1320.0, funcionario.calculaPagamento(), 0.001);
	}
	@Test
	public void testCalculaPagamentoAcimaDoSalarioMinimo() {
		Funcionario funcionario = new Funcionario("João", 50, 60.0);
		double salarioMinimo = 1320.0;
		double valorEsperado = 50 * 60.0; // 3000.0
		assertTrue(valorEsperado >= salarioMinimo);
		assertEquals(valorEsperado, funcionario.calculaPagamento(), 0.01);
	}
}
