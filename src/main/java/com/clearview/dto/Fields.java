package com.clearview.dto;

import java.util.Date;
import java.util.List;

public class Fields {
	private int agentId;
    private String agentName;
    private Date startDate;
    private String type;
    private String priority;
    private String company;
    private boolean completed;
    private int totalDuration;
    private List<SummaryState> summaryStates;
	public int getAgentId() {
		return agentId;
	}
	public void setAgentId(int agentId) {
		this.agentId = agentId;
	}
	public String getAgentName() {
		return agentName;
	}
	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
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
	public boolean isCompleted() {
		return completed;
	}
	public void setCompleted(boolean completed) {
		this.completed = completed;
	}
	public int getTotalDuration() {
		return totalDuration;
	}
	public void setTotalDuration(int totalDuration) {
		this.totalDuration = totalDuration;
	}
	public List<SummaryState> getSummaryStates() {
		return summaryStates;
	}
	public void setSummaryStates(List<SummaryState> summaryStates) {
		this.summaryStates = summaryStates;
	}
	
	@Override
	public String toString() {
		return "Field [agentId=" + agentId + ", agentName=" + agentName + ", startDate=" + startDate + ", type=" + type
				+ ", priority=" + priority + ", company=" + company + ", completed=" + completed + ", totalDuration="
				+ totalDuration + ", summaryStates=" + summaryStates + "]";
	}
    
    
}
