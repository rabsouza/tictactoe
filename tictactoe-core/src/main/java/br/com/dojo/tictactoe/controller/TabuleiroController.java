package br.com.dojo.tictactoe.controller;

import br.com.dojo.tictactoe.model.Jogada;
import br.com.dojo.tictactoe.view.TabuleiroView;

public interface TabuleiroController {

	public abstract boolean jogoFinalizado();

	public abstract void preencherRodada(TabuleiroView tabuleiro, Jogada jogada, Integer rodadaCorrente);

	public abstract boolean validarJogada(Jogada jogada);

}