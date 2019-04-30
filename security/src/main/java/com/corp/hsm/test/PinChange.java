package com.corp.hsm.test;

import java.util.List;

import com.en.datavsn.EFTswitch.hsm.HSMChannel;
import com.en.datavsn.EFTswitch.hsmutil.ArrayUtil;
import com.en.datavsn.EFTswitch.hsmutil.HSMErrorCodes;

import crypto.annotation.Decrypted;
import crypto.annotation.Encrypted;

public class PinChange {

	HSMCommands hsm = new HSMCommands(HSM.getHSMChannelInstanse());

	/**
	 * 
	 * @return new pin offset
	 */
	public String validateAndchangePin(@Encrypted String oldPinBlock, @Encrypted String newPinBlock, @Decrypted String panNumber, String pinOffset, String pvk,
			String tpkUnderLmk) throws Exception {

		String extractPanBase = extractAccountNumberPart(panNumber);
		System.out.println("in extractPanBase -----------" + extractPanBase);

		String resCode = hsm.verifyTerminalPinWithIBMAlgorithm(tpkUnderLmk, pvk, extractPanBase, oldPinBlock, ArrayUtil.padright(pinOffset, 12, 'F'));

		if (resCode != null && resCode.equalsIgnoreCase("00")) {
			System.out.println("HSM_SUCCESS_RESPONSE  extractPanBase------" + extractPanBase);

			String generatedOffset = hsm.generateIBMPinOffset(tpkUnderLmk, extractPanBase, newPinBlock, pvk);

			return generatedOffset.substring(0, 4);

		} else {
			throw new Exception("Wrong Old pin");
		}
	}

	private String extractAccountNumberPart(String accountNumber) {
		String accountNumberPart = null;
		if (accountNumber.length() > 12)
			accountNumberPart = accountNumber.substring(accountNumber.length() - 13, accountNumber.length() - 1);
		else
			accountNumberPart = accountNumber;
		return accountNumberPart;
	}

}
