package com.app.core;

import java.util.Date;
import static com.app.core.Employee.sdf;

public class AadharCard {
	private String cardNumber;
	private Date creationDate;
	private String location;

	public AadharCard(String cardNumber, Date creationDate, String location) {
		super();
		this.cardNumber = cardNumber;
		this.creationDate = creationDate;
		this.location = location;
	}

	@Override
	public String toString() {
		return ", AadharCard [cardNumber=" + cardNumber + ", creationDate=" + sdf.format(creationDate) + ", location="
				+ location + "]";
	}

}
