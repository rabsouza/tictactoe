package br.com.dojo.tictactoe.controller;

import br.com.dojo.tictactoe.model.Jogada;
import br.com.dojo.tictactoe.view.TabuleiroView;

public class TabuleiroControllerImpl implements TabuleiroController {

	private Boolean jogoFinalizado = false;

	@Override
	public boolean jogoFinalizado() {
		return jogoFinalizado;
	}

	@Override
	public void preencherRodada(TabuleiroView tabuleiro, Jogada jogada, Integer rodadaCorrente) {
		if (rodadaCorrente == 3) {
			jogoFinalizado = true;
		}
	}

	@Override
	public boolean validarJogada(Jogada jogada) {
		return true;
	}

}
