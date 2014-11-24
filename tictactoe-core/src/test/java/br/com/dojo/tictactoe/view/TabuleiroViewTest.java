package br.com.dojo.tictactoe.view;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TabuleiroViewTest {

	@Spy
	private TabuleiroViewImpl tabuleiro;

	@Test
	public void aoSolicitarTabuleiroZeradoNaoExibiException() {
		tabuleiro.zerarTabuleiro();
	}

	@Test
	public void aoSolicitarExibirTabuleiroNaoExibiException() {
		tabuleiro.exibirTabuleiro();
	}

	@Test
	public void aoChecarTabuleiroCompletoRetornaFalse() {
		boolean tabuleiroCompleto = tabuleiro.tabuleiroCompleto();
		assertFalse("Tabuleiro deve está vazio!", tabuleiroCompleto);
	}

	@Test
	public void aoPreencherTabuleiroEChecarTabuleiroCompletoRetornaTrue() {
		tabuleiro.atualizarTabuleiro(new int[][] {
				{ 1, -1, 1 },
				{ -1, 1, -1 },
				{ -1, 1, 1 }
		});
		tabuleiro.exibirTabuleiro();
		boolean tabuleiroCompleto = tabuleiro.tabuleiroCompleto();
		assertTrue("Tabuleiro deve está cheio!", tabuleiroCompleto);
	}

}
