package com.clearview.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.clearview.common.ApiConstants;
import com.clearview.dto.Fields;
import com.clearview.dto.OutputPostDto;
import com.clearview.dto.RequestDTO;
import com.clearview.dto.SummaryState;
import com.clearview.dto.Ticket;

@Component
public class ApiUtils {

	public List<OutputPostDto> generatePostData(RequestDTO request) throws ParseException {
		List<OutputPostDto> lstresult = new ArrayList<>();
		for(Ticket t: request.getTickets()) {
			OutputPostDto result = new OutputPostDto();
			result.setTicketID(String.valueOf(t.getId()));
			result.setKey(t.getKey());
			for( Fields f: t.getFields()){
				result.setAgentName(f.getAgentName());
				result.setStartDate(dateFormat(f.getStartDate()));	
				result.setType(f.getType());
				result.setPriority(f.getPriority());
				result.setCompany(f.getCompany());
				result.setCompleted(String.valueOf(f.isCompleted()));
				result.setTotalDuration(String.valueOf(f.getTotalDuration()));
				for(SummaryState s: f.getSummaryStates()) {
					if(s.getName().equalsIgnoreCase(ApiConstants.OPEN)) {						
						result.setOpen(String.valueOf(s.getDuration()));
					}
					else if(s.getName().equalsIgnoreCase(ApiConstants.IN_PROGRESS)) {
						result.setInProgress(String.valueOf(s.getDuration()));
					}
					else if(s.getName().equalsIgnoreCase(ApiConstants.WAITING)) {
						result.setWaiting(String.valueOf(s.getDuration()));
					}else if(s.getName().equalsIgnoreCase(ApiConstants.INTERNAL_VALIDATION)){
						result.setInternalValidation(String.valueOf(s.getDuration()));						
					}
				}
			}
			lstresult.add(result);
		}
		return lstresult;
	}
	
	
	public String dateFormat(Date pDate) throws ParseException {
		DateFormat dateFormat2 = new SimpleDateFormat(ApiConstants.PATTERN_DATE_FORMAT);
		String dateString = dateFormat2.format(pDate);
		dateString = dateString.replaceAll(ApiConstants.STANDARD_AM,ApiConstants.CUSTOM_AM);
		dateString = dateString.replaceAll(ApiConstants.STANDARD_PM,ApiConstants.CUSTOM_PM);
		return dateString;
	}
	
}
