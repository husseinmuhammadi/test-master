package com.javastudio.tutorial.utility.expression;

import java.nio.ByteBuffer;
import java.util.Locale;

/**
 * Created by h.mohammadi on 12/19/2016.
 */
public class StringUtils {
    public static String toLowercaseFirstLetter(final String originalStr, final Locale locale) {
        final int splitIndex = 1;
        final String result;
        if (originalStr.isEmpty()) {
            result = originalStr;
        } else {
            result = Character.toLowerCase(originalStr.charAt(0)) + originalStr.substring(1);
            /*
            final String first = originalStr.substring(0, splitIndex).toLowerCase(locale);
            final String rest = originalStr.substring(splitIndex);
            final StringBuilder uncapStr = new StringBuilder(first).append(rest);
            result = uncapStr.toString();
            */
        }
        return result;
    }

    /**
     * http://stackoverflow.com/questions/11208479/how-do-i-initialize-a-byte-array-in-java
     */
    public static byte[] hexStringToByteArray(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                    + Character.digit(s.charAt(i + 1), 16));
        }
        return data;
    }

    public static int[] toIntDigits(String s) {
        char[] list = s.toCharArray();
        int[] digits = new int[s.length()];

        for (int i = 0; i < s.length(); i++) {
            digits[i] = Character.digit(list[i], 10);
        }
        return digits;
    }

    public static byte[] toByteDigits(String s) {
        byte[] data = new byte[s.length()];
        for (int i = 0; i < s.length(); i++)
            data[i] = (byte) Character.digit(s.charAt(i), 10);
        return data;
    }

    public byte[] toBytes(int i) {
        ByteBuffer b = ByteBuffer.allocate(4);
        // b.order(ByteOrder.BIG_ENDIAN); // optional, the initial order of a byte buffer is always BIG_ENDIAN.
        b.putInt(i);
        return b.array();
    }


    public byte[] toBytes2(int i) {
        byte[] result = new byte[4];

        result[0] = (byte) (i >> 24);
        result[1] = (byte) (i >> 16);
        result[2] = (byte) (i >> 8);
        result[3] = (byte) (i /*>> 0*/);

        return result;
    }
}
