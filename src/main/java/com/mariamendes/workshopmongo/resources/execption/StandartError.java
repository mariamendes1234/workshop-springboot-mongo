package com.mariamendes.workshopmongo.resources.execption;

import java.io.Serializable;

public class StandartError implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long timestamp;
	private Integer status;
	private String error;
	private String menssage;
	private String path;
	
	public StandartError() {
		
	}

	public StandartError(Long timestamp, Integer status, String error, String menssage, String path) {
		super();
		this.timestamp = timestamp;
		this.status = status;
		this.error = error;
		this.menssage = menssage;
		this.path = path;
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public Integer getStatus() {
		return status;
	}

	public String getError() {
		return error;
	}

	public String getMenssage() {
		return menssage;
	}

	public String getPath() {
		return path;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public void setError(String error) {
		this.error = error;
	}

	public void setMenssage(String menssage) {
		this.menssage = menssage;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
	
}
