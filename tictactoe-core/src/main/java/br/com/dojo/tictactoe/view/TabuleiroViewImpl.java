package br.com.dojo.tictactoe.view;

public class TabuleiroViewImpl implements TabuleiroView {

	private int[][] tabuleiro = new int[LINHAS_TAB][COLUNAS_TAB];

	@Override
	public void atualizarTabuleiro(int[][] tabuleiro) {
		this.tabuleiro = tabuleiro;
	}

	public TabuleiroViewImpl() {
		zerarTabuleiro();
	}

	@Override
	public void exibirTabuleiro() {
		quebrarLinhaView();
		exibirCorpoTabuleiro();
		quebrarLinhaView();
	}

	private void exibirCorpoTabuleiro() {
		System.out.println("------------");
		for (int linha = 0; linha < LINHAS_TAB; linha++) {
			for (int coluna = 0; coluna < COLUNAS_TAB; coluna++) {
				if (tabuleiro[linha][coluna] == VALOR_TAB_PLAYER_A) {
					System.out.print(CHAR_TAB_PLAYER_A);
				}
				if (tabuleiro[linha][coluna] == VALOR_TAB_PLAYER_B) {
					System.out.print(CHAR_TAB_PLAYER_B);
				}
				if (tabuleiro[linha][coluna] == VALOR_TAB_NULO) {
					System.out.print(CHAR_TAB_NULO);
				}
				if ((coluna == 0) || (coluna == 1)) {
					System.out.print("|");
				}
			}
			System.out.println();
		}
		System.out.println("------------");
	}

	@Override
	public boolean tabuleiroCompleto() {
		for (int linha = 0; linha < LINHAS_TAB; linha++) {
			for (int coluna = 0; coluna < COLUNAS_TAB; coluna++) {
				if (tabuleiro[linha][coluna] == VALOR_TAB_NULO) {
					return false;
				}
			}
		}
		return true;
	}

	@Override
	public void zerarTabuleiro() {
		for (int linha = 0; linha < LINHAS_TAB; linha++) {
			for (int coluna = 0; coluna < COLUNAS_TAB; coluna++) {
				tabuleiro[linha][coluna] = VALOR_TAB_NULO;
			}
		}
	}

	@Override
	public void quebrarLinhaView() {
		System.out.println();
		System.out.println();
	}

}
