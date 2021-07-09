package com.bean;

import java.io.Serializable;

/**
 * ��ɫʵ��
 * @author Administrator
 *
 */
public class Role implements Serializable {

	private Integer id;
	private String name;
	
	public Role() {
	}

	public Role(Integer id) {
		this.id = id;
	}

	public Role(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", name=" + name + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}