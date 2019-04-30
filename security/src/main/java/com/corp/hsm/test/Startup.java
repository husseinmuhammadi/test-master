package com.corp.hsm.test;

import com.en.datavsn.EFTswitch.hsm.HSMChannel;

public class Startup {

	public static void main(String[] args) {

		PinChange pinChange = new PinChange();
		
		
		String oldPinBlock = "600639BE21666FB8";		
		String newPinBlock = "33532DE591F18C1A";		
		String panNumber = "5859471010067944";
		String pinOffset = "5849";		
		String pvk = "908D5F0F36205382";		
		String tpkUnderLmk = "U31D80D2864B34509F4D277705636BB58";
		try {
			String offset = pinChange.validateAndchangePin(oldPinBlock, newPinBlock, panNumber, pinOffset, pvk, tpkUnderLmk);
			System.out.println(offset);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
