package cn.feng.bean;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Message {
	private String number;//住院号
	@DateTimeFormat
	private String date;//时间
	private String id;//身份证
	private String name;//姓名
	private String sex;//性别
	public Message() {
		super();
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	@Override
	public String toString() {
		return "Mesaage [number=" + number + ", date=" + date + ", id=" + id + ", name=" + name + ", sex=" + sex + "]";
	}
	
}
