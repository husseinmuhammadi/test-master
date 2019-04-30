package com.corp.hsm.test;

import java.util.Date;

public class CardData {

	private String cardNumber;
	private Date expDate;
	private String cvv1;
	private String cvv2;
	private String track2Data;

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public Date getExpDate() {
		return expDate;
	}

	public void setExpDate(Date expDate) {
		this.expDate = expDate;
	}

	public String getCvv1() {
		return cvv1;
	}

	public void setCvv1(String cvv1) {
		this.cvv1 = cvv1;
	}

	public String getCvv2() {
		return cvv2;
	}

	public void setCvv2(String cvv2) {
		this.cvv2 = cvv2;
	}

	public String getTrack2Data() {
		return track2Data;
	}

	public void setTrack2Data(String track2Data) {
		this.track2Data = track2Data;
	}

	public static Object[] getHeaders() {
		return new Object[] { "Card Number", "Expire Date", "CVV1", "CVV2", "Track2Data", "Track2Data" };
	}

	public Object[] getValues() {
		return new Object[] { cardNumber, Convert.toString(expDate, "MM/dd/yyyy"), cvv1, cvv2, track2Data, track2Data.substring(1, track2Data.length() - 1) };
	}
}
