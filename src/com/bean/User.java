package com.bean;

import java.io.Serializable;

/**
 * 用户实体
 * @author Administrator
 *
 */
public class User implements Serializable {

	private Integer id;
	private String userName;
	private String password;
	private Integer gender;
	private Integer age;
	private String phone;
	private String address;
	private Integer roleId;
	
	private Role role;
	
	public User() {
	}

	public User(Integer id) {
		this.id = id;
	}

	public User(String userName, String password, Integer gender, Integer age, String phone, String address,
			Integer roleId) {
		this.userName = userName;
		this.password = password;
		this.gender = gender;
		this.age = age;
		this.phone = phone;
		this.address = address;
		this.roleId = roleId;
	}

	public User(Integer id, String userName, String password, Integer gender, Integer age, String phone, String address,
			Integer roleId) {
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.gender = gender;
		this.age = age;
		this.phone = phone;
		this.address = address;
		this.roleId = roleId;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", password=" + password + ", gender=" + gender + ", age="
				+ age + ", phone=" + phone + ", address=" + address + ", roleId=" + roleId + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
	
}
