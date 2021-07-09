package com.bean;

/**
 * 供应商实体类
 * @author asuna
 *
 */
public class Supplier {

	private Integer id;
	private String name;
	private String detail;
	private String contacts;
	private String phone;
	private String fax;
	private String address;
	
	public Supplier() {
	}

	public Supplier(Integer id) {
		this.id = id;
	}

	public Supplier(Integer id, String name, String detail, String contacts, String phone, String fax, String address) {
		this.id = id;
		this.name = name;
		this.detail = detail;
		this.contacts = contacts;
		this.phone = phone;
		this.fax = fax;
		this.address = address;
	}

	@Override
	public String toString() {
		return "Supplier [id=" + id + ", name=" + name + ", detail=" + detail + ", contacts=" + contacts + ", phone="
				+ phone + ", fax=" + fax + ", address=" + address + "]";
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

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getContacts() {
		return contacts;
	}

	public void setContacts(String contacts) {
		this.contacts = contacts;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
}
