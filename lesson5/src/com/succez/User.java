package com.succez;

public class User {
	private String name;
	private String password;
	private boolean isadmin;
	private int age;
	private String sex;
	private String email;
	private int phone;

	public User(String name, String password, boolean isadmin, int age,
			String sex, String email, int phone) {
		this.name = name;
		this.password = password;
		this.isadmin = isadmin;
		this.age = age;
		this.sex = sex;
		this.email = email;
		this.phone = phone;

	}

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String pw) {
		this.password = pw;

	}

	public boolean getisAdmin() {
		return isadmin;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;

	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;

	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

}
