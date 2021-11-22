package com.clearview.dto;

public class OutputPostDto {

	private String ticketID ;
	private String key ;
	private String agentName; 
	private String startDate ;
	private String type ;
	private String priority; 
	private String company ;
	private String completed; 
	private String totalDuration; 
	private String open ;
	private String inProgress; 
	private String waiting ;
	private String InternalValidation;
	public String getTicketID() {
		return ticketID;
	}
	public void setTicketID(String ticketID) {
		this.ticketID = ticketID;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getAgentName() {
		return agentName;
	}
	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getCompleted() {
		return completed;
	}
	public void setCompleted(String completed) {
		this.completed = completed;
	}
	public String getTotalDuration() {
		return totalDuration;
	}
	public void setTotalDuration(String totalDuration) {
		this.totalDuration = totalDuration;
	}
	public String getOpen() {
		return open;
	}
	public void setOpen(String open) {
		this.open = open;
	}
	public String getInProgress() {
		return inProgress;
	}
	public void setInProgress(String inProgress) {
		this.inProgress = inProgress;
	}
	public String getWaiting() {
		return waiting;
	}
	public void setWaiting(String waiting) {
		this.waiting = waiting;
	}
	public String getInternalValidation() {
		return InternalValidation;
	}
	public void setInternalValidation(String internalValidation) {
		InternalValidation = internalValidation;
	}
	@Override
	public String toString() {
		return "OutputPostDto [ticketID=" + ticketID + ", key=" + key + ", agentName=" + agentName + ", startDate="
				+ startDate + ", type=" + type + ", priority=" + priority + ", company=" + company + ", completed="
				+ completed + ", totalDuration=" + totalDuration + ", open=" + open + ", inProgress=" + inProgress
				+ ", waiting=" + waiting + ", InternalValidation=" + InternalValidation + "]";
	}
}
