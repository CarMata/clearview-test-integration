package com.clearview.service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.clearview.common.ApiConstants;
import com.clearview.dto.OutputPostDto;
import com.clearview.dto.RequestDTO;
import com.clearview.util.ApiUtils;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ApiServiceImpl implements ApiService {
	@Autowired
	private Environment env;
	@Autowired
	private ApiUtils apiUtils;
	@Autowired
	private ObjectMapper mapper;
	
	private static final Logger logger = LoggerFactory.getLogger(ApiServiceImpl.class);

	public void outputGet() {
		String directory = env.getProperty(ApiConstants.STANDARD_KEY_PATH);
		String jsonName = env.getProperty(ApiConstants.STANDARD_JSON_NAME);
		try {
			String jsonFilePath = directory.concat(jsonName);
			RequestDTO fileData = mapper.readValue(Paths.get(jsonFilePath).toFile(), RequestDTO.class);
			String outputFilename = env.getProperty(ApiConstants.STANDARD_GET_OUTPUTNAME);
			String filePath = directory.concat(outputFilename);
			generateFile(fileData, filePath);
		} catch (Exception e) {
			logger.error("Error al procesar datos, method: outputGet(), ex =>",e);
		}

	}

	public void outputPost(RequestDTO request) {
		String directory = env.getProperty(ApiConstants.STANDARD_KEY_PATH);
		String outputFilename = env.getProperty(ApiConstants.STANDARD_POST_OUTPUTNAME);
		try {
			String filePath = directory.concat(outputFilename);
			generateFile(request, filePath);
		} catch (Exception e) {
			logger.error("Error al procesar datos, method: outputPost(), ex =>",e);
		}
	}
	
	

	private void generateFile(RequestDTO pData, String outputPath) {
		FileWriter flwriter = null;
		BufferedWriter bfwriter = null;
		try {
			List<OutputPostDto> result = apiUtils.generatePostData(pData);
			flwriter = new FileWriter(outputPath);
			bfwriter = new BufferedWriter(flwriter);
			bfwriter.write(
					"ticketID, key, agentName, startDate, type, priority, company, completed, totalDuration, open, inProgress, waiting, internalValidation\n");
			for (OutputPostDto r : result) {
				bfwriter.write(r.getTicketID() + ", " + r.getKey() + ", " + r.getAgentName() + ", " + r.getStartDate()
						+ ", " + r.getType() + ", " + r.getPriority() + ", " + r.getCompany() + ", " + r.getCompleted()
						+ ", " + r.getTotalDuration() + ", " + r.getOpen() + ", " + r.getInProgress() + ", "
						+ r.getWaiting() + ", " + r.getInternalValidation() + "\n");
			}
			logger.info("Datos procesados, method: generateFile, path: "+outputPath);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			try {
				bfwriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}
