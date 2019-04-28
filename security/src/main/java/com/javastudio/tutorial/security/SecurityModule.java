package com.javastudio.tutorial.security;

import com.corp.hsm.test.HSM;
import com.corp.hsm.test.HSMCommands;
import com.en.datavsn.EFTswitch.hsmutil.ArrayUtil;
import com.en.pinhsm.CryptoUtil;
import com.en.pinhsm.PinHandler;
import com.en.pinhsm.PinUtil;
import org.jpos.iso.ISOUtil;
import org.jpos.security.EncryptedPIN;

import javax.ejb.Singleton;

import static com.en.pinhsm.PinUtil.hextoGraphics;

@Singleton
public class SecurityModule {
    String pvk = "908D5F0F36205382";
    String tpkUnderLmk = "U31D80D2864B34509F4D277705636BB58";

    final String TMK1 = "CE54E52A235BF20807980801291F7A9B";
    final String TMK2 = "94B33E1AD66D5D7932A438237A795EAE";
    final String TMK3 = "00000000000000000000000000000000";
    final String XTPK = "EF51188DA752D700BE0D3543FCE1BF0B";

    HSMCommands hsm = new HSMCommands(HSM.getHSMChannelInstanse());

    public String generatePinOffset(String cardNumber, String pin) {

        try {
            String extractPanBase = extractAccountNumberPart(cardNumber);

            String atmPinBlock = "U" + createAtmPinBlock(cardNumber, pin);
            String pinBlock = PinUtil.graphic2hex(atmPinBlock.substring(1));

            String generatedOffset = hsm.generateIBMPinOffset(tpkUnderLmk, extractPanBase, pinBlock, pvk);
            return generatedOffset.substring(0, 4);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    private String extractAccountNumberPart(String accountNumber) {
        String accountNumberPart = null;
        if (accountNumber.length() > 12)
            accountNumberPart = accountNumber.substring(accountNumber.length() - 13, accountNumber.length() - 1);
        else
            accountNumberPart = accountNumber;
        return accountNumberPart;
    }

    public String createAtmPinBlock(String span, String pin) throws Exception {
        String pan = EncryptedPIN.extractAccountNumberPart(span);
        if (TMK1.length() == 32) {
            byte part1[] = ISOUtil.hex2byte(TMK1);
            byte part2[] = ISOUtil.hex2byte(TMK2);
            byte part3[] = ISOUtil.hex2byte(TMK3);
            byte key[] = ArrayUtil.xor(part1, part2, part3);
            byte zpk[] = CryptoUtil.desede(ISOUtil.hex2byte(XTPK), key, CryptoUtil.DECRYPT_MODE);
            PinHandler ph = new PinHandler(ISOUtil.hexString(zpk));
            byte[] pb = ph.getEncryptedPin_DKE(pin, pan);
            return hextoGraphics(ISOUtil.hexString(pb));
        } else {
            byte part1[] = ISOUtil.hex2byte(TMK1);
            byte part2[] = ISOUtil.hex2byte(TMK2);
            byte part3[] = ISOUtil.hex2byte(TMK3);
            byte key[] = ArrayUtil.xor(part1, part2, part3);
            byte zpk[] = CryptoUtil.des(ISOUtil.hex2byte(XTPK), key, CryptoUtil.DECRYPT_MODE);
            PinHandler ph = new PinHandler(ISOUtil.hexString(zpk));
            byte[] pb = ph.getEncryptedPin(pin, pan);
            return hextoGraphics(ISOUtil.hexString(pb));
        }

    }
}
