package br.com.dojo.tictactoe.util;

import static org.junit.Assert.assertTrue;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import br.com.dojo.tictactoe.model.Jogador.JogadorEnum;
import br.com.dojo.tictactoe.model.JogadorHumano;

public class JsonUtilsTest {

	@Test
	public void aoSerializarParaJsonObjetoNuloRetornaNulo() {
		assertTrue("Espera resultado nulo!", StringUtils.isBlank(JsonUtils.toJson(null)));
	}

	@Test
	public void aoSerializarParaJsonObjetNaoNuloRetornaJson() {
		JogadorHumano jogador = new JogadorHumano(JogadorEnum.PLAYER_A);
		assertTrue("Espera resultado não nulo!", StringUtils.isNotBlank(JsonUtils.toJson(jogador)));
	}

}
