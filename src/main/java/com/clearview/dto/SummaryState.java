package com.clearview.dto;

public class SummaryState {
    private int id;
    private String name;
    private int duration;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	@Override
	public String toString() {
		return "SummaryState [id=" + id + ", name=" + name + ", duration=" + duration + "]";
	}
    
    
}
