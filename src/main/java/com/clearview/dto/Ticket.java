package com.clearview.dto;

import java.util.List;

public class Ticket {
	 public int id;
	 private String key;
	 private List<Fields> fields;
	 
	 
	 
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getKey() {
		return key;
	}



	public void setKey(String key) {
		this.key = key;
	}



	public List<Fields> getFields() {
		return fields;
	}



	public void setFields(List<Fields> fields) {
		this.fields = fields;
	}



	@Override
	public String toString() {
		return "Tickets [id=" + id + ", key=" + key + ", fields=" + fields + "]";
	}

	 
	 
}
