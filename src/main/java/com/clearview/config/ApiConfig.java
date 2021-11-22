package com.clearview.config;
import java.text.ParseException;
import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class ApiConfig {

	private static final Logger logger = LoggerFactory.getLogger(ApiConfig.class);

	@Bean
	public ObjectMapper mapper() {
		ObjectMapper mapper = null;
		try {
			mapper = new ObjectMapper();
			mapper.setSerializationInclusion(Include.NON_NULL);
			mapper.configure(Feature.AUTO_CLOSE_SOURCE, true);
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		} catch (Exception e) {
			logger.error("Error al configurar objectMapper =>", e);
		}
		return mapper;
	}
	@PostConstruct
    public void init() throws ParseException {

        TimeZone.setDefault(TimeZone.getTimeZone("GMT/UTC"));
    }
	
}
