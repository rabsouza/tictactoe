package br.com.dojo.tictactoe.view;

public interface TabuleiroView {

	Integer COLUNAS_TAB = 3;
	Integer LINHAS_TAB = 3;

	Integer VALOR_TAB_NULO = 0;
	Integer VALOR_TAB_PLAYER_A = -1;
	Integer VALOR_TAB_PLAYER_B = 1;

	String CHAR_TAB_NULO = "   ";
	String CHAR_TAB_PLAYER_A = " X ";
	String CHAR_TAB_PLAYER_B = " O ";

	void zerarTabuleiro();

	void exibirTabuleiro();

	boolean tabuleiroCompleto();

	void atualizarTabuleiro(int[][] tabuleiro);

	void quebrarLinhaView();

}