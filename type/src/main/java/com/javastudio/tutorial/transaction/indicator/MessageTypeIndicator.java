package com.javastudio.tutorial.transaction.indicator;


import com.javastudio.tutorial.exception.InvalidMessageTypeIndicatorException;
import com.javastudio.tutorial.exception.TypeNotFoundException;
import com.javastudio.tutorial.utility.expression.StringUtils;

import java.io.Serializable;
import java.text.MessageFormat;

/**
 * A message type indicator includes
 * the ISO 8583 version, the Message Class, the Message Function and the Message Origin,
 * each described briefly in the following sections.
 * The following example (MTI 0110) lists what each digit indicates:
 * 0xxx -> version of ISO 8583 (for example: 1987 version)
 * x1xx -> class of the Message for example: Authorization Message)
 * xx1x -> function of the Message (for example: Request Response)
 * xxx0 -> who began the communication (for example: Acquirer)
 */

public class MessageTypeIndicator implements Serializable {

    private static final long serialVersionUID = -6147892484471322340L;

    //region Fields
    private final MessageVersion version;
    private final MessageClass classification;
    private final MessageFunction function;
    private final MessageOrigin origin;
    //endregion

    // todo add super class for these fields
    //region MessageVersion, MessageClass, MessageFunction, MessageOrigin
    public enum MessageVersion {
        ISO8583_VERSION_1987(0),
        ISO8583_VERSION_1993(1),
        ISO8583_VERSION_2003(2);

        private final int value;
        private final String description;

        MessageVersion(int value, String description) {
            this.value = value;
            this.description = description;
        }

        MessageVersion(int value) {
            this(value, null);
        }

        public static MessageVersion instanceOf(int value) {
            // if (value == null || value.isEmpty()) return null;

            for (MessageVersion version : values())
                if (version.getValue() == value)
                    return version;

            throw new TypeNotFoundException(MessageFormat.format("Could not create {0} for [{1}]", MessageVersion.class.getName(), value));
        }

        public int getValue() {
            return value;
        }

        public byte getByte() {
            return (byte) value;
        }

        public String getDescription() {
            return description;
        }
    }

    public enum MessageClass {
        AUTHORIZATION(1),
        FINANCIAL(2),
        FILE_ACTIONS(3),
        REVERSAL_AND_CHARGEBACK(4),
        RECONCILIATION(5),
        ADMINISTRATIVE(6),
        FEE_COLLECTION(7),
        NETWORK_MANAGEMENT(8),
        ;

        private final int value;
        private final String description;

        MessageClass(int value, String description) {
            this.value = value;
            this.description = description;
        }

        MessageClass(int value) {
            this(value, null);
        }

        public static MessageClass instanceOf(int value) {
            // if (value == null || value.isEmpty()) return null;

            for (MessageClass messageClass : values())
                if (messageClass.getValue() == value)
                    return messageClass;

            throw new TypeNotFoundException(MessageFormat.format("Could not create {0} for [{1}]", Class.class.getName(), value));
        }

        public int getValue() {
            return value;
        }

        public byte getByte() {
            return (byte) value;
        }

        public String getDescription() {
            return description;
        }
    }

    public enum MessageFunction {
        REQUEST(0),
        REQUEST_RESPONSE(1),
        ADVICE(2),
        ADVICE_RESPONSE(3),
        NOTIFICATION(4),
        NOTIFICATION_ACKNOWLEDGEMENT(5),
        INSTRUCTION(6), // ISO 8583:2003 only
        INSTRUCTION_ACKNOWLEDGEMENT(7), // ISO 8583:2003 only
        ;

        private final int value;
        private final String description;

        MessageFunction(int value, String description) {
            this.value = value;
            this.description = description;
        }

        MessageFunction(int value) {
            this(value, null);
        }

        public static MessageFunction instanceOf(int value) {
            // if (value == null || value.isEmpty()) return null;

            for (MessageFunction function : values())
                if (function.getValue() == value)
                    return function;

            throw new TypeNotFoundException(MessageFormat.format("Could not create {0} for [{1}]", MessageFunction.class.getName(), value));
        }

        public int getValue() {
            return value;
        }

        public byte getByte() {
            return (byte) value;
        }

        public String getDescription() {
            return description;
        }
    }

    public enum MessageOrigin {
        ACQUIRER(0),
        ACQUIRER_REPEAT(1),
        ISSUER(2),
        ISSUER_REPEAT(3),
        OTHER(4),
        OTHER_REPEAT(5), //
        ;

        private final int value;
        private final String description;

        MessageOrigin(int value, String description) {
            this.value = value;
            this.description = description;
        }

        MessageOrigin(int value) {
            this(value, null);
        }

        public static MessageOrigin instanceOf(int value) {
            // if (value == null || value.isEmpty()) return null;

            for (MessageOrigin origin : values())
                if (origin.getValue() == value)
                    return origin;

            throw new TypeNotFoundException(MessageFormat.format("Could not create {0} for [{1}]", MessageOrigin.class.getName(), value));
        }

        public int getValue() {
            return value;
        }

        public byte getByte() {
            return (byte) value;
        }

        public String getDescription() {
            return description;
        }
    }
    //endregion

    //region Constructor
    private MessageTypeIndicator(int version, int classification, int function, int origin) {
        this.version = MessageVersion.instanceOf(version);
        this.classification = MessageClass.instanceOf(classification);
        this.function = MessageFunction.instanceOf(function);
        this.origin = MessageOrigin.instanceOf(origin);
    }

    public MessageTypeIndicator(MessageVersion version, MessageClass classification, MessageFunction function, MessageOrigin origin) {
        this(version.getValue(), classification.getValue(), function.getValue(), origin.getValue());
    }

    private MessageTypeIndicator(byte[] b) {
        this(b[0], b[1], b[2], b[3]);
    }

    private MessageTypeIndicator(String mti) {
        this(StringUtils.toByteDigits(mti));
    }
    //endregion

    static MessageTypeIndicator valueOf(byte[] b) {
        return new MessageTypeIndicator(b);
    }

    public static MessageTypeIndicator valueOf(String mti) throws InvalidMessageTypeIndicatorException {
        try {
            return new MessageTypeIndicator(mti);
        } catch (Exception e) {
            throw new InvalidMessageTypeIndicatorException(e);
        }
    }

    //region Getter and Setter
    public byte[] getBytes() {
        return new byte[]{version.getByte(), classification.getByte(), function.getByte(), origin.getByte()};
    }

    public String getMTI() {
        return String.valueOf(version.getValue()) + classification.getValue() + function.getValue() + origin.getValue();
    }

    public MessageVersion getVersion() {
        return version;
    }

    public MessageClass getClassification() {
        return classification;
    }

    public MessageFunction getFunction() {
        return function;
    }

    public MessageOrigin getOrigin() {
        return origin;
    }
    //endregion

    //region Override

    /**
     * todo check this method
     *
     * @return
     */
    @Override
    public String toString() {
        // return super.toString() + "[" + ISOUtil.hexString(getBytes()) + "]";
        return "" + version.getValue() + classification.getValue() + function.getValue() + origin.getValue();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MessageTypeIndicator that = (MessageTypeIndicator) o;

        if (version != that.version) return false;
        if (classification != that.classification) return false;
        if (function != that.function) return false;
        return origin == that.origin;

    }

    @Override
    public int hashCode() {
        int result = version != null ? version.hashCode() : 0;
        result = 31 * result + (classification != null ? classification.hashCode() : 0);
        result = 31 * result + (function != null ? function.hashCode() : 0);
        result = 31 * result + (origin != null ? origin.hashCode() : 0);
        return result;
    }
    //endregion


}
