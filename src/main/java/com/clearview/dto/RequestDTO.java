package com.clearview.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RequestDTO {
	   @JsonProperty("Tickets") 
	    private List<Ticket> tickets;

	public List<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}

	@Override
	public String toString() {
		return "RequestDTO [tickets=" + tickets + "]";
	}

	

	
}
