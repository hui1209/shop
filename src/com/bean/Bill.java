package com.bean;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 账单实体类
 * @author asuna
 *
 */
public class Bill implements Serializable {

	private Integer id;
	private Integer money;
	private String unti;
	private Integer number;
	private String name;
	private String detail;
	private String supplier;
	private Integer payment;
	private Date time;
	
	public Bill() {
	}

	public Bill(Integer id) {
		this.id = id;
	}

	public Bill(Integer id, Integer money, String unti, Integer number, String name, String detail, String supplier,
			Integer payment, String time) {
		this.id = id;
		this.money = money;
		this.unti = unti;
		this.number = number;
		this.name = name;
		this.detail = detail;
		this.supplier = supplier;
		this.payment = payment;
		setTime(time);
	}
	
	public Bill(Integer id, Integer money, String unti, Integer number, String name, String detail, String supplier,
			Integer payment, Date time) {
		this.id = id;
		this.money = money;
		this.unti = unti;
		this.number = number;
		this.name = name;
		this.detail = detail;
		this.supplier = supplier;
		this.payment = payment;
		this.time = time;
	}

	@Override
	public String toString() {
		return "Bill [id=" + id + ", money=" + money + ", unti=" + unti + ", number=" + number + ", name=" + name
				+ ", detail=" + detail + ", supplier=" + supplier + ", payment=" + payment + ", time=" + time + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getMoney() {
		return money;
	}

	public void setMoney(Integer money) {
		this.money = money;
	}

	public String getUnti() {
		return unti;
	}

	public void setUnti(String unti) {
		this.unti = unti;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
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

	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	public Integer getPayment() {
		return payment;
	}

	public void setPayment(Integer payment) {
		this.payment = payment;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public void setTime(String time) {
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			this.time = format.parse(time);
		} catch (ParseException e) {
			this.time = new Date();
		}
	}
	
}
