package test;

import java.util.Date;

public class Users {
	
	private String name;
	
	private String sex;
	
	private Date birthday;
	
	private int age;
	
	

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



	public Date getBirthday() {
		return birthday;
	}



	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}



	public int getAge() {
		return age;
	}



	public void setAge(int age) {
		this.age = age;
	}



	public Users(String name, String sex, int age, Date birthday) {
		super();
		this.name = name;
		this.sex = sex;
		this.birthday = birthday;
		this.age = age;
	}



}
