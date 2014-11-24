package br.com.dojo.tictactoe.app;

import java.util.Locale;
import java.util.Scanner;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;

import br.com.dojo.tictactoe.controller.TabuleiroController;
import br.com.dojo.tictactoe.controller.TabuleiroControllerImpl;
import br.com.dojo.tictactoe.model.Jogada;
import br.com.dojo.tictactoe.model.Jogador;
import br.com.dojo.tictactoe.model.Jogador.JogadorEnum;
import br.com.dojo.tictactoe.model.JogadorHumano;
import br.com.dojo.tictactoe.view.TabuleiroView;
import br.com.dojo.tictactoe.view.TabuleiroViewImpl;

public class JogoApp {

	private final static Integer MAXIMO_TENTATIVA = 5;
	private final static String DELIMITADOR_JOGADA = ";";

	private TabuleiroView tabuleiro = new TabuleiroViewImpl();
	private TabuleiroController controller = new TabuleiroControllerImpl();
	private Scanner entrada = new Scanner(System.in);

	private Integer rodadaCorrente;
	private Jogador jogadorCorrente;

	public JogoApp() {
		entrada.useDelimiter(System.lineSeparator());
		entrada.useLocale(Locale.getDefault());
		rodadaCorrente = 0;
		carregarNotasIniciais();
	}

	public void iniciarJogoDaVelha() {

		Jogador jogadorA = new JogadorHumano(JogadorEnum.PLAYER_A);
		Jogador jogadorB = new JogadorHumano(JogadorEnum.PLAYER_B);

		preencherJogador(jogadorA, 1);
		preencherJogador(jogadorB, 2);

		tabuleiro.exibirTabuleiro();

		jogadorCorrente = carregarJogadorInicial(jogadorA, jogadorB);
		System.out
				.println("Observação: Cada jogada deve ser no formato linha;coluna do tabuleiro.\natA posição 0;0 representa o canto superior esquerdo e a posição 2;2 representa o canto inferior direito.an");
		while (!controller.jogoFinalizado()) {

			Jogada jogada = preencherJogada(jogadorCorrente, rodadaCorrente);
			controller.preencherRodada(tabuleiro, jogada, rodadaCorrente);
			carregarProximoJogadorERodada(jogadorA, jogadorB);
		}

		carregarStatusFinalJogo(jogadorA, jogadorB);

	}

	private void carregarProximoJogadorERodada(Jogador... jogadores) {
		if (ArrayUtils.isEmpty(jogadores) || (jogadores.length < 2)) {
			interroperExecucaoPorError();
		}

		jogadorCorrente = jogadorCorrente.getIndice() == JogadorEnum.PLAYER_A.getIndice() ? jogadores[1] : jogadores[0];

		rodadaCorrente++;
	}

	private Jogador carregarJogadorInicial(Jogador... jogadores) {
		if (ArrayUtils.isEmpty(jogadores) || (jogadores.length < 2)) {
			interroperExecucaoPorError();
		}

		int index = RandomUtils.nextInt(0, 9999) % 2;
		return jogadores[index];

	}

	private Jogada preencherJogada(Jogador jogadorCorrente, Integer rodadaCorrente2) {
		Jogada jogada = new Jogada(jogadorCorrente);

		jogada.setTentativa(processarTentativaJogador(jogadorCorrente, rodadaCorrente2));
		while (!controller.validarJogada(jogada)) {
			jogada.setTentativa(processarTentativaJogador(jogadorCorrente, rodadaCorrente2));
		}
		return jogada;
	}

	private Integer[] processarTentativaJogador(Jogador jogadorCorrente, Integer rodadaCorrente) {

		Integer[] tentativa = null;

		int count = 0;
		for (; count < MAXIMO_TENTATIVA; count++) {
			System.out.print(String.format("Rodada[%s], %s informe sua jogada (linha;coluna): ", rodadaCorrente + 1, jogadorCorrente.getNome()));
			String tentativaStr = entrada.next();
			if (StringUtils.isBlank(tentativaStr) || (tentativaStr.length() < 3) || !tentativaStr.contains(DELIMITADOR_JOGADA)) {
				System.out.println("Jogada inválida!\nLembre-se cada jogada deve ser no formato linha;coluna. O delimitador utilizado é ;.");
			} else {
				String[] tentativaArray = StringUtils.split(tentativaStr, DELIMITADOR_JOGADA);
				if ((tentativaArray.length == 2) && StringUtils.isNumeric(tentativaArray[0]) && StringUtils.isNumeric(tentativaArray[1])) {
					tentativa = new Integer[2];
					tentativa[0] = Integer.parseInt(tentativaArray[0]);
					tentativa[1] = Integer.parseInt(tentativaArray[1]);
					break;
				} else {
					System.out.println("Jogada inválida!\nLembre-se cada jogada deve ser no formato linha;coluna. O delimitador utilizado é ;.");
				}
			}
		}
		return tentativa;
	}

	private void carregarStatusFinalJogo(Jogador jogadorA, Jogador jogadorB) {
		tabuleiro.quebrarLinhaView();
		System.out.println("########################################################################");
		System.out.println("O Jogo foi finalizado com o resultado abaixo:");
		System.out.println(jogadorA.getStatusFinal());
		System.out.println(jogadorB.getStatusFinal());
		System.out.println("########################################################################");
		tabuleiro.quebrarLinhaView();
	}

	private void preencherJogador(Jogador jogador, int numJogador) {
		if (jogador == null) {
			interroperExecucaoPorError();
		}

		String nomeJogador = null;
		int count = 0;
		for (; count < MAXIMO_TENTATIVA; count++) {
			System.out.print(String.format("Informe o nick do jogador[%s]: ", numJogador));
			nomeJogador = entrada.next();
			if (validarNomeJogador(nomeJogador)) {
				jogador.setNome(nomeJogador);
				break;
			} else {
				System.out.println("Obs.: Nick do jogador deve conter somente letras e números, não é permitidos caracteres especiais.");
			}
			System.out.println();
		}

		if (count == MAXIMO_TENTATIVA) {
			jogador.setNome(jogador.getJogador().name());
		}

	}

	private void interroperExecucaoPorError() {
		System.out.println("Erro na inicialização do app! Favor entrar em contato com o desenvolvedor!");
		System.exit(1);
	}

	private boolean validarNomeJogador(String nomeJogador) {
		return StringUtils.isNotBlank(nomeJogador) && StringUtils.isAlphanumeric(nomeJogador);
	}

	private void carregarNotasIniciais() {
		tabuleiro.quebrarLinhaView();
		System.out.println("########################################################################");
		System.out.println("App: Jogo da Velha!");
		System.out.println("Versão: 1.0.0");
		System.out.println("Obs.: Para jogar são necessários 2 jogadores!");
		System.out.println("########################################################################");
		tabuleiro.quebrarLinhaView();
	}

}
