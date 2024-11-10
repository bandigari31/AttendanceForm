package com.bean;

import java.sql.Date;
import java.sql.Time;

public class BeanClass {

	private int gin;
	private String name;
	private Date date;
	private String workingstatus;
	private Time time;

	public BeanClass(int gin,String name,String workingstatus, Time time) {
		super();
		this.gin = gin;
		this.name=name;
		this.workingstatus=workingstatus;
		this.time=time;
		//this.date = date;

	}

	public int getGin() {
		return gin;
	}

	public void setGin(int gin) {
		this.gin = gin;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getWorkingstatus() {
		return workingstatus;
	}

	public void setWorkingstatus(String workingstatus) {
		this.workingstatus = workingstatus;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

}
