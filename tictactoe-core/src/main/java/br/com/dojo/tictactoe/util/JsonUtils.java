package br.com.dojo.tictactoe.util;

import java.io.IOException;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtils {

	private static final Logger LOGGER = Logger.getLogger(JsonUtils.class);

	public static String toJson(Object obj) {

		if (obj == null) {
			return null;
		}

		String json = null;
		try {
			ObjectMapper mapper = new ObjectMapper();
			json = mapper.writeValueAsString(obj);

		} catch (JsonGenerationException e) {
			LOGGER.error(e.getMessage(), e);
		} catch (JsonMappingException e) {
			LOGGER.error(e.getMessage(), e);
		} catch (IOException e) {
			LOGGER.error(e.getMessage(), e);
		}

		return json;

	}

}
