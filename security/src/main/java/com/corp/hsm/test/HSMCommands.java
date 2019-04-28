package com.corp.hsm.test;

import java.io.EOFException;
import java.net.SocketException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.jpos.iso.ISOException;

import com.en.datavsn.EFTswitch.codec.Parser;
import com.en.datavsn.EFTswitch.common.DatavsnConstant;
import com.en.datavsn.EFTswitch.hsm.HSMChannel;
import com.en.datavsn.EFTswitch.hsm.RacalCommands;
import com.en.datavsn.EFTswitch.hsmutil.HSMErrorCodes;

public class HSMCommands {

	private HSMChannel channel;
	private RacalCommands hsmcommands;
	String cvk1 = "361927CB2095C253";
	String cvk2 = "3317E2DE742DA9DE";

	// ezpk = "U18AC29E808A71BD3FD7305D01F267FA6";
	// epvk = "5AB901F9F3E7A68C";
	// pan = "777652010007";
	// pb ="9CE72F6C70C2D0F9";
	// format ="01";
	// offset = "0000FFFFFFFF";

	// 5859476520108575
	// 5859471010067944
	String pan = "947101006794";
	String expdt = "2005";
	// for cvv1 -> 101
	// for cvv2 -> 000
	// for cvv3 -> 999
	String serviceCode = "101"; // CVV = 110

	final String cvv1ServiceCode = "101";
	final String cvv2ServiceCode = "000";
	final String cvv3ServiceCode = "999";

	public HSMCommands(HSMChannel channel) {
		this.channel = channel;
		hsmcommands = new RacalCommands();
		hsmcommands.setHSM(channel);
	}

	public String generateCvv1(String cardNumber, Date expDate) {

		System.out.println("Generate cvv1 ... ");
		System.out.println("Card Number : " + cardNumber);

		String pan = cardNumber.substring(3, 15);
		System.out.println("Pan is : " + pan);
		System.out.println("Expire Date : " + expDate.toString());

		String serviceCode = "101";

		SimpleDateFormat sdf = new SimpleDateFormat("yyMM");
		String expdt = sdf.format(expDate);

		Parser res1;
		try {
			res1 = hsmcommands.generateVISACVV(cvk1, cvk2, pan, expdt, serviceCode);

			String resError = (String) res1.getValue("error");
			System.out.println("error: " + resError);
			String cvv1 = (String) res1.getValue("cvv");
			System.out.println("cvv1 : " + cvv1);

			res1.dump(System.out, "<--");

			Thread.sleep(100);

			return cvv1;

		} catch (SocketException e) {
			// e.printStackTrace();
			System.out.println("SocketException: Connection abort - receive failed");
		} catch (ISOException e) {
			// e.printStackTrace();
			System.out.println("ISOException: Unconnected ISOChannel");
		} catch (EOFException e) {
			// e.printStackTrace();
			System.out.println("");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public String generateCvv2(String cardNumber, Date expDate) {

		System.out.println("Generate cvv2 ... ");
		System.out.println("Card Number : " + cardNumber);

		String pan = cardNumber.substring(3, 15);
		System.out.println("Pan is : " + pan);
		System.out.println("Expire Date : " + expDate.toString());

		String serviceCode = "000";

		SimpleDateFormat sdf = new SimpleDateFormat("yyMM");
		String expdt = sdf.format(expDate);

		Parser res1;
		try {
			res1 = hsmcommands.generateVISACVV(cvk1, cvk2, pan, expdt, serviceCode);

			String resError = (String) res1.getValue("error");
			System.out.println("error: " + resError);
			String cvv2 = (String) res1.getValue("cvv");
			System.out.println("cvv2 : " + cvv2);

			res1.dump(System.out, "<--");

			Thread.sleep(100);

			return cvv2;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public String generateTrack2Data(String cardNumber, Date expDate) {

		String track2Data = null;

		System.out.println("Generate track 2 data ... ");
		System.out.println("Card Number : " + cardNumber);

		String pan = cardNumber.substring(3, 15);
		System.out.println("Pan is : " + pan);
		System.out.println("Expire Date : " + expDate.toString());

		String serviceCode = "101";

		SimpleDateFormat sdf = new SimpleDateFormat("yyMM");
		String expdt = sdf.format(expDate);

		String cvv1 = generateCvv1(cardNumber, expDate);

		if (cvv1 != null)
			track2Data = generateTrack2Data(cardNumber, expdt, serviceCode, cvv1);

		return track2Data;
	}

	private String generateTrack2Data(String cardNumber, String expdt, String serviceCode, String cvv1) {
		String result = null;
		try {
			// String eDate = DateUtil.formatDate(expiryDate, "yyMM");
			result = DatavsnConstant.getConstant(DatavsnConstant.START_SENTIMENTAL_TRACK2);
			result += cardNumber;
			result += DatavsnConstant.getConstant(DatavsnConstant.TRACK2_FIELD_SEPERATOR);
			// result += eDate;
			result += expdt;
			result += serviceCode;
			result += cvv1;
			result += DatavsnConstant.getConstant(DatavsnConstant.TRACK2_RESERVED_CARD_ISSUER);
			result += DatavsnConstant.getConstant(DatavsnConstant.TRACK2_LONGITUTE_REDENDECY_CHECK);
			result += DatavsnConstant.getConstant(DatavsnConstant.TRACK2_END_SENTIMENTAL);

			System.out.println("Track2Data: " + result);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	public String verifyTerminalPinWithIBMAlgorithm(String tpkUnderLmk, String pvk, String extractPanBase, String oldPinBlock, String pinOffset) {
		String resCode = null;
		try {
			Parser res = hsmcommands.VerifyTerminalPINwithIBMAlgorithm(tpkUnderLmk, pvk, extractPanBase, oldPinBlock, "01", pinOffset);

			if (res == null)
				throw new Exception("Can't connect to HSM");

			res.dump();
			resCode = (String) res.getValue("error");
			System.out.println("Error : " + resCode);
			System.out.println("Error Desc: " + HSMErrorCodes.getInstance().getError(resCode));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resCode;
	}

	public String generateIBMPinOffset(String tpkUnderLmk, String extractPanBase, String newPinBlock, String pvk) throws Exception {
		Parser newRes = hsmcommands.translatePinTPKtoLMK(tpkUnderLmk, "01", extractPanBase, newPinBlock);
		newRes.dump();
		String newPin = (String) newRes.getValue("pin");
		Parser newOffset = hsmcommands.generateIBMPinOffset(pvk, extractPanBase, newPin);
		return (String) newOffset.getValue("offset");
	}

}
