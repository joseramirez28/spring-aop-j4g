package org.l4g.spring.xml.model;

import java.awt.IllegalComponentStateException;

public class ClientInfo {

	private String name;
	private String email;
	private int daysWithoutShopping;
	private ClientStatus status;

	public ClientInfo() {
	}

	public ClientInfo(String name, String email, int daysWithoutShopping, ClientStatus status) {
		super();
		this.name = name;
		this.email = email;
		this.daysWithoutShopping = daysWithoutShopping;
		this.status = status;
	}

	public void printClientInfo() {
		System.out.println("Client name : " + this.name);
		System.out.println("email : " + this.email);
		System.out.println("Days without shopping : " + this.daysWithoutShopping);
		if (this.status == null) {
			System.out.println("Days without shopping : " + ClientStatus.UNDEFINED);
		} else {
			System.out.println("Client status: " + this.status);
		}
	}

	public void printName() {
		System.out.println("Client name : " + this.name);
	}

	public boolean isClientInExpiredStatus() {
		if (this.daysWithoutShopping < 0) {
			throw new IllegalComponentStateException("Invalid days count");
		}
		int months = this.daysWithoutShopping / 30;

		return months > 3;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getDaysWithoutShopping() {
		return daysWithoutShopping;
	}

	public void setDaysWithoutShopping(int daysWithoutShopping) {
		this.daysWithoutShopping = daysWithoutShopping;
	}

	public ClientStatus getStatus() {
		return status;
	}

	public void setStatus(ClientStatus status) {
		this.status = status;
	}

}
