package com.bodmas.model;

import java.awt.image.BufferedImage;
import java.io.InputStream;



public class Storage {

	private int id;
	private String details;
	private InputStream files;
	
	private BufferedImage s;
	
	



	public BufferedImage getS() {
		return s;
	}

	public void setS(BufferedImage s) {
		this.s = s;
	}

	public String getDetails() {
		return details;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setDetails(String details) {
		this.details = details;
	}
	public InputStream getFiles() {
		return files;
	}
	public void setFiles(InputStream files) {
		this.files = files;
	}
	public Storage(String details, InputStream files) {
		super();
		this.details = details;
		this.files = files;
	}
	public Storage(int id, String details,InputStream files) {
		this.id=id;
		this.details=details;
		//this.files=files;
		this.s = s;
	}

	@Override
	public String toString() {
		return "Storage [id=" + id + ", details=" + details + ", files=" + files + "]";
	}

	
	
	
}
