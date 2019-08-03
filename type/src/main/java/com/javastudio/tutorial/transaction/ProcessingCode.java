package com.javastudio.tutorial.transaction;

import com.javastudio.tutorial.exception.TypeNotFoundException;

import java.util.EnumSet;

import static com.javastudio.tutorial.transaction.indicator.MessageTypeIndicator.MessageClass;

/**
 * The following is a table specifying the message type and processing code for each transaction type.
 * <p/>
 * Transaction	    Message Type	Processing Code
 * Authorization	0100	        00 a0 0x
 * Balance Inquiry	0100	        31 a0 0x
 * Sale	            0200	        00 a0 0x
 * Cash	            0200	        01 a0 0x
 * Void	            0200	        02 a0 0x
 * Mobile Topup	    0200	        57 a0 0x
 */
public enum ProcessingCode {
    PURCHASE("00", "PU") {
        @Override
        public EnumSet<MessageClass> allowedMti() {
            return EnumSet.of(MessageClass.AUTHORIZATION, MessageClass.FINANCIAL, MessageClass.REVERSAL_AND_CHARGEBACK);
        }
    },

    CASH_WITHDRAWAL("01", "WD") {
        @Override
        public EnumSet<MessageClass> allowedMti() {
            return EnumSet.of(MessageClass.FINANCIAL, MessageClass.REVERSAL_AND_CHARGEBACK);
        }
    },

    REFUND("20", "RF") {
        @Override
        public EnumSet<MessageClass> allowedMti() {
            return EnumSet.of(MessageClass.FINANCIAL, MessageClass.REVERSAL_AND_CHARGEBACK);
        }
    },

    BALANCE_ENQUIRY("31", "BI") {
        @Override
        public EnumSet<MessageClass> allowedMti() {
            return EnumSet.of(MessageClass.AUTHORIZATION);
        }
    },

    CUSTOMER_ENQUIRY("33", "VI") {
        @Override
        public EnumSet<MessageClass> allowedMti() {
            return EnumSet.of(MessageClass.AUTHORIZATION);
        }
    },

    MINI_STATEMENT("34", "MS") {
        @Override
        public EnumSet<MessageClass> allowedMti() {
            return EnumSet.of(MessageClass.AUTHORIZATION);
        }
    },

    FUND_TRANSFER("40", "TI") {
        @Override
        public EnumSet<MessageClass> allowedMti() {
            return EnumSet.of(MessageClass.FINANCIAL, MessageClass.REVERSAL_AND_CHARGEBACK);
        }
    },

    FUND_TRANSFER_DR("46", "TF") {
        @Override
        public EnumSet<MessageClass> allowedMti() {
            return EnumSet.of(MessageClass.FINANCIAL, MessageClass.REVERSAL_AND_CHARGEBACK);
        }
    },

    FUND_TRANSFER_CR("47", "TT") {
        @Override
        public EnumSet<MessageClass> allowedMti() {
            return EnumSet.of(MessageClass.FINANCIAL, MessageClass.REVERSAL_AND_CHARGEBACK);
        }
    },

    PAYMENT("50", "PM") {
        @Override
        public EnumSet<MessageClass> allowedMti() {
            return EnumSet.of(MessageClass.FINANCIAL, MessageClass.REVERSAL_AND_CHARGEBACK);
        }
    },

    PIN_VERIFICATION("71", "CV") {
        @Override
        public EnumSet<MessageClass> allowedMti() {
            return EnumSet.of(MessageClass.AUTHORIZATION);
        }
    },

    DT_TRANSACTION("90", "DT") {
        @Override
        public EnumSet<MessageClass> allowedMti() {
            return EnumSet.of(MessageClass.FINANCIAL);
        }
    },

    PIN_CHANGE("80", "") {
        @Override
        public EnumSet<MessageClass> allowedMti() {
            return EnumSet.of(MessageClass.AUTHORIZATION);
        }
    },

    PIN2_CHANGE("93", "") {
        @Override
        public EnumSet<MessageClass> allowedMti() {
            return EnumSet.of(MessageClass.AUTHORIZATION);
        }
    },

    // For ndc purpose only
    CASH_REVERSAL("15", "", true) {
        @Override
        public EnumSet<MessageClass> allowedMti() {
            return EnumSet.of(MessageClass.FINANCIAL);
        }
    },

    BILL_PAYMENT_VALIDATE("19", "", true) {
        @Override
        public EnumSet<MessageClass> allowedMti() {
            return EnumSet.of(MessageClass.AUTHORIZATION);
        }
    },

    PINPAD_PIN_VERIFICATION("94", "", true) {
        @Override
        public EnumSet<MessageClass> allowedMti() {
            return EnumSet.of(MessageClass.AUTHORIZATION);
        }
    },

    ACCOUNT_INQUIRY("98", "", true) {
        @Override
        public EnumSet<MessageClass> allowedMti() {
            return EnumSet.of(MessageClass.AUTHORIZATION);
        }
    },

    LOAN_ACCOUNT_INQUIRY("72", "", true) {
        @Override
        public EnumSet<MessageClass> allowedMti() {
            return EnumSet.of(MessageClass.AUTHORIZATION);
        }
    },

    LOAN_OUTSTANDING_INQUIRY("77", "", true) {
        @Override
        public EnumSet<MessageClass> allowedMti() {
            return EnumSet.of(MessageClass.AUTHORIZATION);
        }
    },

    UPDATE_CASSETTE_COUNTERS_1_AND_2("61", "", true) {
        @Override
        public EnumSet<MessageClass> allowedMti() {
            return EnumSet.of(MessageClass.AUTHORIZATION);
        }
    },

    UPDATE_CASSETTE_COUNTERS_3_AND_4("63", "", true) {
        @Override
        public EnumSet<MessageClass> allowedMti() {
            return EnumSet.of(MessageClass.AUTHORIZATION);
        }
    },

    NOT_DEFINED("ND", "", true) {
        @Override
        public EnumSet<MessageClass> allowedMti() {
            return null;
        }
    },
    ;

    private final String value;
    private final String typeOfTransaction;
    private final boolean ndc;

    public abstract EnumSet<MessageClass> allowedMti();

    ProcessingCode(String processingCode, String typeOfTransaction) {
        this(processingCode, typeOfTransaction, false);
    }

    ProcessingCode(String value, String typeOfTransaction, boolean ndc) {
        this.value = value;
        this.typeOfTransaction = typeOfTransaction;
        this.ndc = ndc;
    }

    public static ProcessingCode getInstance(String value) {
        if (value == null || value.isEmpty())
            return null;

        for (ProcessingCode processingCode : values()) {
            if (processingCode.getValue().equals(value))
                return processingCode;
        }

        throw new TypeNotFoundException(ProcessingCode.class.getName()
                + " Error creating instance for Processing Code : " + value);
    }

    public String getValue() {
        return this.value;
    }

    public String getTypeOfTransaction() {
        return typeOfTransaction;
    }

    public String getFullName() {
        return this.getClass().getName() + "." + this.name();
    }

    public boolean isNdc() {
        return ndc;
    }
}
