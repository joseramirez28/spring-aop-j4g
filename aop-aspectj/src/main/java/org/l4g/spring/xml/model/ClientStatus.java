package org.l4g.spring.xml.model;

public enum ClientStatus {

	ACTIVE("active"), INACTIVE("inactive"), UNDEFINED("undefined");

	String statusString;

	ClientStatus(String statusString) {
		this.statusString = statusString;
	}
}
