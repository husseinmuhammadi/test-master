package com.en.datavsn.EFTswitch.common;

import java.io.FileInputStream;
import java.util.Properties;
public class DatavsnConstant
{
	public static final String TXN_CODE_TOP_UP="TXN_CODE_TOP_UP";
	public static final String TOP_UP_TRANSACTIONTYPE="TOP_UP_TRANSACTIONTYPE";
	public static final String CREDIT_TRANSACTION="CREDIT_TRANSACTION";
	public static final String DEBIT_TRANSACTION="DEBIT_TRANSACTION";

	public static final String TXN_CODE_MOVE_FUND_DEBIT="TXN_CODE_MOVE_FUND_DEBIT";
	public static final String TXN_CODE_MOVE_FUND_CREDIT="TXN_CODE_MOVE_FUND_CREDIT";
	public static final String  PENDING="PENDING";
	public static final String CARD_PERSONALIZED="CARD_PERSONALIZED";
	public static final String CARD_NOT_PERSONALIZED="CARD_NOT_PERSONALIZED";
	public static final String GREEN_CARD_PERSONALIZED="GREEN_CARD_PERSONALIZED";
	public static final String CONSIDER_DEFAULT_LIMIT="CONSIDER_DEFAULT_LIMIT";
	public static final String GENERATE_PIN="GENERATE_PIN";
	public static final String CARD_NOT_ACTIVE="CARD_NOT_ACTIVE";
	public static final String NILL_BALANCE="NILL_BALANCE";
	public static final String NILL_OTP_BALANCE="NILL_OTP_BALANCE";
	public static final String CARD_ACTIVE="CARD_ACTIVE";
	public static final String DEFAULT_CLIENT_TYPE="DEFAULT_CLIENT_TYPE";
	//public static final String TXN_CODE_TOP_UP_REVERSAL="TR";

	public static final String CHANNEL_TYPE="CHANNEL_TYPE";
	public static final String DEFAULT_RENEWAL_STATUS="DEFAULT_RENEWAL_STATUS";
	public static final String RENEWAL_STATUS_DONE="RENEWAL_STATUS_DONE";
	public static final String REPLACEMENT_DONE="REPLACEMENT_DONE";
	public static final String RENEWAL_RELPACEMENT="RENEWAL_RELPACEMENT";
	public static final String SET_FEE_COMMENT="SET_FEE_COMMENT";
	public static final String DESCRIPTION="DESCRIPTION";
	public static final String AUTO_RENEWAL="AUTO_RENEWAL";
	public static final String REGISTERATION_ACCEPTED_STATUS="REGISTERATION_ACCEPTED_STATUS";
	public static final String LIMIT_TYPE="LIMIT_TYPE";
	public static final String ACCEPTED_STATUS="ACCEPTED_STATUS";
	public static final String CARD_TYPE="CARD_TYPE";
	public static final String CLIENT_EXISTS="CLIENT_EXISTS";
	public static final String CLIENTDOESNOT_EXISTS="CLIENTDOESNOT_EXISTS";
    public static final String ACTIVE_CARD_STATUS="ACTIVE_CARD_STATUS";
    public static final String SUSPEND_CARD_STATUS="SUSPEND_CARD_STATUS";
    public static final String FROM_TO_CARD_NUMBER="FROM_TO_CARD_NUMBER";

	public static final String TXN_CODE_PURCHASE="TXN_CODE_PURCHASE";
	public static final String TXN_CODE_CHARGE_BACK="";
	public static final String TXN_CODE_CASH_ADVANCE="";
	public static final String TXN_CODE_WITH_DRAWAL="TXN_CODE_WITH_DRAWAL";
	public static final String TXN_CODE_FUND_TRANSFER="TXN_CODE_FUND_TRANSFER";
	public static final String TXN_CODE_UNIQUE_TRANSFER="";
	public static final String TXN_CODE_CREDIT_VOUCHER="";
	public static final String TXN_CODE_REGULATION_FEES="";
	public static final String TXN_CODE_ADD_PORT_IMPL="";
	public static final String TXN_CODE_CHARGE_BACK_FEE="";
	public static final String TXN_CODE_ANNUAL_MEMBERSHIP_FEE="";
	public static final String TXN_CODE_INVESTMENT_FEE="";
	public static final String TXN_CODE_FAITH_COLLECTION="";
	public static final String TXN_CODE_COPY_REQUEST_FEE="";
	public static final String TXN_CODE_REJ_TO_MERC_H="";
	public static final String TXN_CODE_PIN_FEES="";
	public static final String TXN_CODE_CARD_FEES="";
	public static final String TXN_CODE_CASH_FEES="";
	public static final String TXN_CODE_CONVERSION_FEES="";
	public static final String TXN_CODE_INSURANCE_FEES="";
	public static final String TXN_CODE_ASSISTANCE_FEES="";
	public static final String TXN_CODE_TICKET_COPY_REQUEST="";
	public static final String TXN_CODE_DUPLICATE_STAT="";
	public static final String TXN_CODE_AUTHORIZATION_BY_PHONE_TELEX="";
	public static final String TXN_CODE_WITHDRAWAL_FEES="";
	public static final String TXN_CODE_CHEQUE_TRANSFER="";
	public static final String TXN_CODE_CASH_TRANSFER="";
	public static final String TXN_CODE_BALANCE_INQUIRY="TXN_CODE_BALANCE_INQUIRY";
	public static final String TXN_CODE_MINI_STATEMENT="TXN_CODE_MINI_STATEMENT";
	public static final String TXN_CODE_INSUFFICIENT_FUNDS="";
	public static final String TXN_CODE_MISCELLANEOUS_FEES="";
	public static final String TXN_CODE_CARD_MISCELLANEOUS_DEBIT="";
	public static final String TXN_CODE_DISCOUNT="";
	public static final String TXN_CODE_EQUIPMENT_FEES="";
	public static final String TXN_CODE_FURNITURE_FEES="";
	public static final String TXN_CODE_LATE_PAYMENT_INTEREST="";
	public static final String TXN_CODE_MERCHANT_TRANSFER="";
	public static final String TXN_CODE_AUTO_DEBIT="";
	public static final String TXN_CODE_MERCHANT_MISCELLANEOUS_DEBIT="";
	public static final String TXN_CODE_MERCHANT_MISCELLANEOUS_CREDIT="";
	public static final String TXN_CODE_CREDIT_PREPAID_REMITTANCE="";
	public static final String TXN_CODE_ADJUST_LATEPAYMENT_INTEREST="";
	public static final String TXN_CODE_CHAIN_TRANSFER_BY_TRANSACTION="";
	public static final String TXN_CODE_MERCHANT_TRANSFER_BY_BALANCE="";
	public static final String TXN_CODE_CHAIN_TRANSFER_BY_BALANCE="";
	public static final String TXN_CODE_ISSUE_CARD_FEE_MC="";
	public static final String TXN_CODE_ISSUE_CARD_FEE_M="";
	public static final String TXN_CODE_DEBIT_PERPAID_REMITTANCE="";
	public static final String TXN_CODE_CHEQUE="";
	public static final String TXN_CODE_DEBTOR_INTEREST="";
	public static final String TXN_CODE_CREDITOR_INTEREST="";
	public static final String TXN_CODE_AUTOMATED_DEPOSIT="";
	public static final String TXN_CODE_OVERDRAWN_FEES="";
	public static final String TXN_CODE_LATE_PAYMENT_FEE="";
	public static final String TXN_CODE_CHEQUE_FEES="";
	public static final String TXN_CODE_VAT="";
	public static final String TXN_CODE_CHEQUE_DEPOSIT="";
	public static final String TXN_CODE_CASH_DEPOSIT="";
	public static final String TXN_CODE_RELOAD="";
	public static final String TXN_CODE_DEPOSIT_RELOAD="";
	public static final String TXN_CODE_SH_A_MISC_DEBIT="";
	public static final String TXN_CODE_SH_A_MISC_CREDIT="";
	public static final String TXN_CODE_EARLY_SETTLEMENT="";
	public static final String TXN_CODE_LITIGATION="";
	public static final String TXN_CODE_TRANSFER="";
	public static final String TXN_CODE_CHEQUE_DEBIT="";
	public static final String TXN_CODE_CASH_DEBIT="";
	public static final String TXN_CODE_SPECIAL_RENEWAL_FEE="";
	public static final String TXN_CODE_EARLY_CLOSE_BAL="";


	public static final String REQ_KEY_TOP_UP = "REQ_KEY_TOP_UP";
	public static final String	REQ_KEY_CLIENT_CARD_NUMBER = "REQ_KEY_CLIENT_CARD_NUMBER";
	public static final String REQ_KEY_TRANS_AMOUNT = "REQ_KEY_TRANS_AMOUNT";
	public static final String REQ_KEY_TRANS_CURRENCY = "REQ_KEY_TRANS_CURRENCY";
	public static final String REQ_KEY_REFERENCE_ID = "REQ_KEY_REFERENCE_ID";
	public static final String REQ_KEY_PAYMENT_PROVIDER = "REQ_KEY_PAYMENT_PROVIDER";
	public static final String REQ_KEY_DESCRIPTION = "REQ_KEY_DESCRIPTION";
	public static final String REQ_KEY_PROGRAM_ID= "REQ_KEY_PROGRAM_ID";
	public static final String REQ_KEY_MESSAGE_ID="REQ_KEY_MESSAGE_ID";
	public static final String REQ_KEY_FEEAMOUNT="REQ_KEY_FEEAMOUNT";//used for paymentauthorization
	public static final String REQ_KEY_MERCHANTCODE="REQ_KEY_MERCHANTCODE";// used for paymentauthorization
	public static final String REQ_KEY_TOPUP_DESCRIPTION="REQ_KEY_TOPUP_DESCRIPTION";
	public static final String REQ_KEY_SETFEE_CODE="REQ_KEY_SETFEE_CODE";
	public static final String REQ_KEY_SETFEE_DESCRIPTION="REQ_KEY_SETFEE_DESCRIPTION";
	public static final String REQ_KEY_CHANNEL_TYPE="REQ_KEY_CHANNEL_TYPE";

	public static final String REQ_KEY_VOID = "REQ_KEY_VOID";
	public static final String REQ_KEY_AUTHORIZATION_NUMBER = "REQ_KEY_AUTHORIZATION_NUMBER";
	public static final String REQ_KEY_BATCH_NUMBER = "REQ_KEY_BATCH_NUMBER";
	public static final String REQ_KEY_TRANSACTION_TYPE="REQ_KEY_TRANSACTION_TYPE";
	public static final String REQ_KEY_REVERSAL_REFERENCE_ID= "REQ_KEY_REVERSAL_REFERENCE_ID";

	public static final String REQ_KEY_MOVE_FUNDS = "REQ_KEY_MOVE_FUNDS";
	public static final String REQ_KEY_TRANSFER_AMOUNT = "REQ_KEY_TRANSFER_AMOUNT";
	public static final String REQ_KEY_CURRENCY = "REQ_KEY_CURRENCY";
	public static final String REQ_KEY_CLIENT_ID_2 = "REQ_KEY_CLIENT_ID_2";
	public static final String REQ_KEY_TO_LAST_FOUR = "REQ_KEY_TO_LAST_FOUR";
	public static final String REQ_KEY_INSTANT_TRANSFER = "REQ_KEY_INSTANT_TRANSFER";
	public static final String REQ_KEY_TRANSFER_DATE = "REQ_KEY_TRANSFER_DATE";
	public static final String REQ_KEY_CARDNUMBER_2 = "REQ_KEY_CARDNUMBER_2";
	public static final String REQ_KEY_NETWORK_CODE="REQ_KEY_NETWORK_CODE";

	//Application ID for MonitorBase Menus
	public static final String APPLICATION_ID="APPLICATION_ID";

	//card holderservcie
	public static final String REVERSAL_STATUS_DONE = "REVERSAL_STATUS_DONE";
	public static final String REVERSAL_STATUS_ERROR = "REVERSAL_STATUS_ERROR";

	public static final String REQ_KEY_REG_REQ = "REQ_KEY_REG_REQ";
	public static final String REQ_KEY_PROD_CODE = "REQ_KEY_PROD_CODE";
	public static final String REQ_KEY_INST_CODE="REQ_KEY_INST_CODE";
	public static final String REQ_KEY_CARD_FLAG = "REQ_KEY_CARD_FLAG";
	public static final String REQ_KEY_FAMILY_STATUS="REQ_KEY_FAMILY_STATUS";
	public static final String REQ_KEY_GENDER="REQ_KEY_GENDER";
	public static final String REQ_KEY_DOCUMENT_TYPE1="REQ_KEY_DOCUMENT_TYPE1";
	public static final String REQ_KEY_LEGAL_ID1="REQ_KEY_LEGAL_ID1";
	public static final String REQ_KEY_DOCUMENT_SCAN1="REQ_KEY_DOCUMENT_SCAN1";
	public static final String REQ_KEY_DOCUMENT_TYPE_2="REQ_KEY_DOCUMENT_TYPE_2";
	public static final String REQ_KEY_LEGAL_ID2="REQ_KEY_LEGAL_ID2";
	public static final String REQ_KEY_DOCUMENT_SCAN2="REQ_KEY_DOCUMENT_SCAN2";
	public static final String REQ_KEY_TITLE="REQ_KEY_TITLE";
	public static final String REQ_KEY_FAMILY_NAME="REQ_KEY_FAMILY_NAME";
	public static final String REQ_KEY_FIRST_NAME="REQ_KEY_FIRST_NAME";
	public static final String REQ_KEY_MIDDLE_NAME="REQ_KEY_MIDDLE_NAME";
	public static final String REQ_KEY_EMBOSSED_NAME="REQ_KEY_EMBOSSED_NAME";
	public static final String REQ_KEY_DOB="REQ_KEY_DOB";
	public static final String REQ_KEY_SECRET_QUESTION="REQ_KEY_SECRET_QUESTION";
	public static final String REQ_KEY_ANSWER_TO_SECRET_QUESTION="REQ_KEY_ANSWER_TO_SECRET_QUESTION";
	public static final String REQ_KEY_SECURE_CODE_PASSWORD="REQ_KEY_SECURE_CODE_PASSWORD";
	public static final String REQ_KEY_EMAIL_1="REQ_KEY_EMAIL_1";
	public static final String REQ_KEY_PHONE_NUMBER_1="REQ_KEY_PHONE_NUMBER_1";
	public static final String REQ_KEY_PHONE_NUMBER_2="REQ_KEY_PHONE_NUMBER_2";
	public static final String REQ_KEY_ADDRESS_LINE1="REQ_KEY_ADDRESS_LINE1";
	public static final String REQ_KEY_ADDRESS_LINE2="REQ_KEY_ADDRESS_LINE2";
	public static final String REQ_KEY_ADDRESS_LINE3="REQ_KEY_ADDRESS_LINE3";
	public static final String REQ_KEY_ADDRESS_LINE4="REQ_KEY_ADDRESS_LINE4";
	public static final String REQ_KEY_CITY="REQ_KEY_CITY";
	public static final String REQ_KEY_REGION_CODE="REQ_KEY_REGION_CODE";
	public static final String REQ_KEY_COUNTRY_CODE="REQ_KEY_COUNTRY_CODE";
	public static final String REQ_KEY_POST_CODE="REQ_KEY_POST_CODE";
	public static final String REQ_KEY_NATIONALITY_CODE="REQ_KEY_NATIONALITY_CODE";
	public static final String REQ_KEY_LANGUAGE_CODE="REQ_KEY_LANGUAGE_CODE";
	public static final String REQ_KEY_PHOTO_REFERENCE="REQ_KEY_PHOTO_REFERENCE";
	public static final String REQ_KEY_REGISTRATION_DATE="REQ_KEY_REGISTRATION_DATE";
	public static final String REQ_KEY_LIMIT_INDEX="REQ_KEY_LIMIT_INDEX";
	public static final String REQ_KEY_ALIAS="REQ_KEY_ALIAS";
	public static final String REQ_KEY_CLIENT_ID="REQ_KEY_CLIENT_ID";
	public static final String REQ_KEY_PRIMARY_CLIENT_ID="REQ_KEY_PRIMARY_CLIENT_ID";
	public static final String REQ_KEY_PRIMARY_CARD_NUMBER="REQ_KEY_PRIMARY_CARD_NUMBER";
	public static final String REQ_KEY_CVV = "REQ_KEY_CVV";
	public static final String REQ_KEY_ACCOUNT_NUMBER= "REQ_KEY_ACCOUNT_NUMBER";

	public static final String REQ_KEY_STATUS="REQ_KEY_STATUS";
	public static final String REQ_KEY_TYPELIST="REQ_KEY_TYPELIST";
	public static final String REQ_KEY_TRANSACTION_CODE="REQ_KEY_TRANSACTION_CODE";

	public static final String REQ_KEY_EMAIL_OPTION="REQ_KEY_EMAIL_OPTION";
	public static final String REQ_KEY_SMS_OPTION="REQ_KEY_SMS_OPTION";

	public static final String REQ_KEY_DATE_FORMAT="REQ_KEY_DATE_FORMAT";
	public static final String REQ_KEY_AMOUNT_SEPERATOR="REQ_KEY_AMOUNT_SEPERATOR";
	public static final String REQ_KEY_OPERATION_FLAG="REQ_KEY_OPERATION_FLAG";
	public static final String REQ_KEY_SET_FEES = "REQ_KEY_SET_FEES";

	public static final String REQ_KEY_UPDATE_PROFILE = "REQ_KEY_UPDATE_PROFILE";
	public static final String REQ_KEY_GET_PROFILE = "REQ_KEY_GET_PROFILE";
	public static final String REQ_KEY_REGISTER_TRANSFER_ACCOUNT= "REQ_KEY_REGISTER_TRANSFER_ACCOUNT";
	public static final String REQ_KEY_GET_RELATED_CLIENT_LIST= "REQ_KEY_GET_RELATED_CLIENT_LIST";
	public static final String REQ_KEY_CHECK_CARD_NUMBER="REQ_KEY_CHECK_CARD_NUMBER";

	public static final String REQ_KEY_TRUSTED_REQUEST_RESP="REQ_KEY_TRUSTED_REQUEST_RESP";
	public static final String REQ_KEY_SET_CLIENT_PREFERENCE="REQ_KEY_SET_CLIENT_PREFERENCE";
	public static final String REQ_KEY_GET_CLIENT_PREFERENCE="REQ_KEY_GET_CLIENT_PREFERENCE";
	public static final String REQ_KEY_SET_ALIAS="REQ_KEY_SET_ALIAS";

	public static final String REQ_KEY_WALLET_MOBILE_NUMBER="REQ_KEY_WALLET_MOBILE_NUMBER";

	public static final String REQ_KEY_WALLET_MOBILE_NUMBER2="REQ_KEY_WALLET_MOBILE_NUMBER2";
	public static final String REQ_KEY_GET_CARDNUMBER = "REQ_KEY_GET_CARDNUMBER";
	public static final String REQ_KEY_CVC2="REQ_KEY_CVC2";
	public static final String REQ_KEY_EXPIRYDATE="REQ_KEY_EXPIRYDATE";
	public static final String REQ_KEY_GET_CVC2 = "REQ_KEY_GET_CVC2";

	public static final String REQ_KEY_GET_EXPIRY_DATE = "REQ_KEY_GET_EXPIRY_DATE";

	public static final String REQ_KEY_TRANSACTION_LIST= "REQ_KEY_TRANSACTION_LIST";

	public static final String REQ_KEY_GET_BALANCE = "REQ_KEY_GET_BALANCE";

	public static final String REQ_KEY_CARDSTATUS = "REQ_KEY_CARDSTATUS";
	public static final String REQ_KEY_AVAILABLE_AMOUNT = "REQ_KEY_AVAILABLE_AMOUNT";

	public static final String REQ_KEY_CURRENCY_CODE = "REQ_KEY_CURRENCY_CODE";//for paymentauthorization also

	public static final String REQ_KEY_START_DATE = "REQ_KEY_START_DATE";
	public static final String REQ_KEY_NUMBER_OF_TRANSACTIONS = "REQ_KEY_NUMBER_OF_TRANSACTIONS";

	public static final String REQ_KEY_END_DATE = "REQ_KEY_END_DATE";
	public static final String REQ_KEY_MINIMUM_AMOUNT = "REQ_KEY_MINIMUM_AMOUNT";

	public static final String REQ_KEY_REVERSAL_FLAG ="REQ_KEY_REVERSAL_FLAG";

	public static final String REQ_KEY_EXIST ="REQ_KEY_EXIST";

	public static final String REQ_CARD_EXIST ="REQ_CARD_EXIST";
	public static final String REQ_KEY_TRANSACTION_DATE = "REQ_KEY_TRANSACTION_DATE";

	//This constant is for GetPostDatedTransfer Process
	public static final String REQ_KEY_CLIENT_ID1="REQ_KEY_CLIENT_ID1";
	public static final String REQ_KEY_CLIENT_ID2="REQ_KEY_CLIENT_ID2";
	public static final String REQ_KEY_TRANSACTION_STATUS="REQ_KEY_TRANSACTION_STATUS";
	public static final String REQ_KEY_TRANSACTION_SIGN="REQ_KEY_TRANSACTION_SIGN";
	public static final String REQ_KEY_TRANSACTION_ID="REQ_KEY_TRANSACTION_ID";
	public static final String REQ_KEY_CREATED_BY="REQ_KEY_CREATED_BY";
	public static final String REQ_KEY_CREATED_ON="REQ_KEY_CREATED_ON";
	public static final String REQ_KEY_MODIFIED_BY="REQ_KEY_MODIFIED_BY";
	public static final String REQ_KEY_MODIFIED_ON="REQ_KEY_MODIFIED_ON";
	public static final String REQ_KEY_GET_POST_DATED_TRANSFERS= "REQ_KEY_GET_POST_DATED_TRANSFERS";
	public static final String REQ_KEY_DELETE_POST_DATED_TRANSFERS= "REQ_KEY_DELETE_POST_DATED_TRANSFERS";
	public static final String REQ_KEY_CURR_PENDING= "REQ_KEY_CURR_PENDING";
	public static final String FEE_APPLY_ON_TRANSACTION = "FEE_APPLY_ON_TRANSACTION";
	public static final String FEE_APPLY_ON_ACCOUNT = "FEE_APPLY_ON_ACCOUNT";
	public static final String REBATE_SEPARATE_TXN_YES = "REBATE_SEPARATE_TXN_YES";
	public static final String REBATE_SEPARATE_TXN_NO = "REBATE_SEPARATE_TXN_NO";
	public static final String REQ_KEY_ACTIVATE_CARD = "REQ_KEY_ACTIVATE_CARD";
	public static final String REQ_KEY_UPDATE_CARD_STATUS = "REQ_KEY_UPDATE_CARD_STATUS";
	public static final String REQ_KEY_ACTIVATION_CODE="REQ_KEY_ACTIVATION_CODE";
	public static final String REQ_KEY_ACTIVATION_DATE="REQ_KEY_ACTIVATION_DATE";
	public static final String REQ_KEY_STATUS_CODE = "REQ_KEY_STATUS_CODE";

	//For BatchCardGeneration
	public static final String REQ_KEY_FROM_CARD_NUMBER="REQ_KEY_FROM_CARD_NUMBER";

	public static final String REQ_KEY_TO_CARD_NUMBER="REQ_KEY_TO_CARD_NUMBER";
	public static final String REQ_KEY_NUMBER_OF_CARDS="REQ_KEY_NUMBER_OF_CARDS";

	public static final String REQ_KEY_BATCH_CARD_GENERATION = "REQ_KEY_BATCH_CARD_GENERATION";

	public static final String REQ_KEY_SINGLE_CARD_GENERATION = "REQ_KEY_SINGLE_CARD_GENERATION";
	public static final String REQ_KEY_REBATE_FLAG = "REQ_KEY_REBATE_FLAG";
	public static final String REQ_KEY_REBATE_AMOUNT = "REQ_KEY_REBATE_AMOUNT";


	//For PaymentAuthorizationrequest
	public static final String REQ_KEY_MERCHANT_NAME = "REQ_KEY_MERCHANT_NAME";
	public static final String REQ_KEY_PURCHASE_TRANSACTION_ID = "REQ_KEY_PURCHASE_TRANSACTION_ID";
	public static final String REQ_KEY_PAYMENT_DATE = "REQ_KEY_PAYMENT_DATE";
	public static final String REQ_KEY_PURCHASE_AMOUNT = "REQ_KEY_PURCHASE_AMOUNT";
	public static final String REQ_KEY_EXPONENT = "REQ_KEY_EXPONENT";
	public static final String REQ_KEY_PIN_BLOCK="REQ_KEY_PIN_BLOCK";
	public static final String REQ_KEY_DIGEST_VALUE="REQ_KEY_DIGEST_VALUE";
	public static final String REQ_KEY_MERCHANT_LOCATION_ID="REQ_KEY_MERCHANT_LOCATION_ID";
	public static final String REQ_KEY_MERCHANT_TRANSACTION_ID="REQ_KEY_MERCHANT_TRANSACTION_ID";

	public static final String PAYMENT_AUTHORIZATION_KEY="PAYMENT_AUTHORIZATION_KEY";
	public static final String REQ_KEY_CVV2_VERIFICATION="REQ_KEY_CVV2_VERIFICATION";
	public static final String REQ_KEY_CVV_USING_ATN="REQ_KEY_CVV_USING_ATN";

	public static final String REQ_CARD_ENCRYPTION_DECRYPTION = "REQ_CARD_ENCRYPTION_DECRYPTION";
	public static final String REQ_KEY_MODE="REQ_KEY_MODE";

	//For IVRS Validation

	public static final String REQ_KEY_MSISDN="REQ_KEY_MSISDN";
	public static final String REQ_KEY_BALANCE_ENQUIRY="REQ_KEY_BALANCE_ENQUIRY";
	public static final String REQ_KEY_LOCK="REQ_KEY_LOCK";
	public static final String REQ_KEY_UN_LOCK="REQ_KEY_UN_LOCK";
	public static final String REQ_KEY_REQ_TYPE="REQ_KEY_REQ_TYPE";
	public static final String REQ_KEY_MINI_STATEMENT="REQ_KEY_MINI_STATEMENT";
	public static final String REQ_KEY_TO_CARD="REQ_KEY_TO_CARD";


	public static final String REQ_KEY_OLD_PIN_BLOCK="REQ_KEY_OLD_PIN_BLOCK";
	public static final String REQ_KEY_NEW_PIN_BLOCK="REQ_KEY_NEW_PIN_BLOCK";
	public static final String REQ_KEY_PERSONALIZATION_AGENT="REQ_KEY_PERSONALIZATION_AGENT";
	public static final String REQ_KEY_COURIER_AGENT="REQ_KEY_COURIER_AGENT";
	public static final String REQ_KEY_RENEWAL_TYPE="REQ_KEY_RENEWAL_TYPE";
	public static final String REQ_KEY_RENEWAL_STATUS="REQ_KEY_RENEWAL_STATUS";
	public static final String REQ_KEY_USER_NAME="REQ_KEY_USER_NAME";
	public static final String REQ_KEY_MWALLET_PIN="REQ_KEY_MWALLET_PIN";
	public static final String REQ_KEY_PASSWORD="REQ_KEY_PASSWORD";
	public static final String PRODUCT_TYPE_MWALLET="PRODUCT_TYPE_MWALLET";
	public static final String MPINHASH_KEY="MPINHASH_KEY";
	public static final String DEFAULT_PIN_OFFSET="DEFAULT_PIN_OFFSET";
	public static final String REQ_KEY_ARN="REQ_KEY_ARN";
	public static final String REQ_KEY_TABLE_NAME="REQ_KEY_TABLE_NAME";
	public static final String REQ_KEY_FORCE_DEBIT="REQ_KEY_FORCE_DEBIT";
	public static final String REQ_KEY_PERSISTANCE="REQ_KEY_PERSISTANCE";
	public static final String REQ_KEY_CONN_TYPE="REQ_KEY_CONN_TYPE";
	public static final String REQ_KEY_CUSTOMER_SELECTABLE_PIN="REQ_KEY_CUSTOMER_SELECTABLE_PIN";
	public static final String REQ_KEY_ATN="REQ_KEY_ATN";
	public static final String REQ_KEY_AUTH_RESULT_CODE="REQ_KEY_AUTH_RESULT_CODE";

	public static final String CVV2_SERVICE_CODE="CVV2_SERVICE_CODE";
	public static final String CVV2_SERVICE_CODE_FOR_ATN="CVV2_SERVICE_CODE_FOR_ATN";
	public static final String CVV3_SERVICE_CODE="CVV3_SERVICE_CODE";

	public static final String REQ_KEY_PIN_CHANGE="REQ_KEY_PIN_CHANGE";
	public static final String REQUEST_TYPE="REQUEST_TYPE";

	public static final String REQ_KEY_CARD_RENEWAL="REQ_KEY_CARD_RENEWAL";
	public static final String REQ_KEY_MANUAL_RENEWAL="REQ_KEY_MANUAL_RENEWAL";
	public static final String REQ_KEY_TOP_UP_REVERSAL="REQ_KEY_TOP_UP_REVERSAL";
	public static final String REQ_KEY_CREDIT_OR_DEBIT="REQ_KEY_CREDIT_OR_DEBIT";
	
	//Added by Chetan, wrt Issue #9518 ,as on 21 Nov 2014
	public static final String REQ_KEY_CUST_ID = "REQ_KEY_CUST_ID";
	
	// track 1 data
	public static final String START_SENTIMENTAL_TRACK1="START_SENTIMENTAL_TRACK1";
	public static final String BANK_FORMAT_CODE="BANK_FORMAT_CODE";
	public static final String TRACK1_FIELD_SEPERATOR="TRACK1_FIELD_SEPERATOR";
	public static final String TRACK1_DESCRETIONARY_DATA="TRACK1_DESCRETIONARY_DATA";
	public static final String TRACK1_RESERVED_CARD_ISSUER="TRACK1_RESERVED_CARD_ISSUER";
	public static final String TRACK1_END_SENTIMENTAL="TRACK1_END_SENTIMENTAL";
	public static final String TRACK1_LONGITUTE_REDENDECY_CHECK="TRACK1_LONGITUTE_REDENDECY_CHECK";

	//track 2Data

	public static final String START_SENTIMENTAL_TRACK2="START_SENTIMENTAL_TRACK2";
	public static final String TRACK2_FIELD_SEPERATOR="TRACK2_FIELD_SEPERATOR";
	public static final String TRACK2_PVV="TRACK2_PVV";
	public static final String TRACK2_RESERVED_CARD_ISSUER="TRACK2_RESERVED_CARD_ISSUER";
	public static final String TRACK2_END_SENTIMENTAL="TRACK2_END_SENTIMENTAL";
	public static final String TRACK2_LONGITUTE_REDENDECY_CHECK="TRACK2_LONGITUTE_REDENDECY_CHECK";

	public static final String CARD_FILE_GENERATION="CARD_FILE_GENERATION";
	public static final String PIN_FILE_GENERATION="PIN_FILE_GENERATION";
	public static final String SINGLE_CARD_REG_NUMBER_OF_CARDS="SINGLE_CARD_REG_NUMBER_OF_CARDS";
	public static final String DEFAULT_PIN_RETRY_COUNT="DEFAULT_PIN_RETRY_COUNT";

	public static final String REQ_KEY_PIN2_CHANGE="REQ_KEY_PIN2_CHANGE";

	/*Newly Replaced file constant*/
	public static final String ISSUER="ISSUER";
	public static final String YES="YES";
	public static final String NO="NO";
	public static final String SUCCESS_CODE="SUCCESS_CODE";
	public static final String FAILURE_CODE="FAILURE_CODE";
	public static final String REGISTERED_OTHER_SECONDARY_CODE="REGISTERED_OTHER_SECONDARY_CODE";
	public static final String OTHER_SECONDARY_CODE="OTHER_SECONDARY_CODE";
	public static final String OTHER_PRIMARY_CODE="OTHER_PRIMARY_CODE";
	public static final String SINGLE="SINGLE";
	public static final String MARRIED="MARRIED";
	public static final String DIVORCE="DIVORCE";
	public static final String WIDOW="WIDOW";
	public static final String MALE="MALE";
	public static final String FEMALE="FEMALE";
	public static final String DOMESTIC="DOMESTIC";
	public static final String INTERNATIONAL="INTERNATIONAL";
	public static final String UKDOMESTIC="UKDOMESTIC";
	public static final String ACTIVATE_CARD="ACTIVATE_CARD";
	public static final String RG="RG";
	public static final String CARD_EXISTS="CARD_EXISTS";
	public static final String CLIENT_PREFERENCE="CLIENT_PREFERENCE";
	public static final String UPDATE="UPDATE";
	public static final String SET="SET";
	public static final String CURRENT_PENDING="CURRENT_PENDING";
	public static final String DELETE_POSTDATED_TRANSFER="DELETE_POSTDATED_TRANSFER";
	public static final String GET_BALANCE="GET_BALANCE";
	public static final String GET_CARD_NUMBER="GET_CARD_NUMBER";
	public static final String GET_CILENT_PREFERENCE="GET_CILENT_PREFERENCE";
	public static final String GET_CVC2="GET_CVC2";
	public static final String GET_EXPIRY_DATE="GET_EXPIRY_DATE";
	public static final String GET_POSTDATED_TRANSFER="GET_POSTDATED_TRANSFER";
	public static final String GET_PROFILE="GET_PROFILE";
	public static final String BALANCE="BALANCE";
	public static final String PAYMENT_AUTHORIZATION_REQUEST="PAYMENT_AUTHORIZATION_REQUEST";
	public static final String TRANSFER="TRANSFER";
	public static final String REGISTER_TRANSFER_REQUEST="REGISTER_TRANSFER_REQUEST";
	public static final String DELETE="DELETE";
	public static final String TYPE_LIST_S="TYPE_LIST_S";
	public static final String TYPE_LIST_T="TYPE_LIST_T";
	public static final String TYPE_LIST_R="TYPE_LIST_R";
	public static final String RELATED_CLIENT_LIST="RELATED_CLIENT_LIST";
	public static final String SET_ALIAS="SET_ALIAS";
	public static final String SET_FEE="SET_FEE";
	public static final String THROUGH_SET_FEEAPI="THROUGH_SET_FEEAPI";
	public static final String DECLINED_STATUS="DECLINED_STATUS";
	public static final String CARD_ACTIVE_STATE="CARD_ACTIVE_STATE";
	public static final String CARD_NOTACTIVE="CARD_NOTACTIVE";
	public static final String CARD_LOST="CARD_LOST";
	public static final String CARD_EXPIRED="CARD_EXPIRED";
	public static final String CARD_STOLEN="CARD_STOLEN";
	public static final String CARD_DAMAGED="CARD_DAMAGED";
	public static final String CARD_SUSPEND="CARD_SUSPEND";
	public static final String CARD_ERRORNEOUS="CARD_ERRORNEOUS";
	public static final String CARD_COUNTERFIT="CARD_COUNTERFIT";
	public static final String CARD_EMERGENCY="CARD_EMERGENCY";
	public static final String CARD_HOTMARKED="CARD_HOTMARKED";
	public static final String CARD_BLOCKED="CARD_BLOCKED";
	public static final String UPDATE_CARD_STATUS="UPDATE_CARD_STATUS";
	public static final String UPDATE_PROFILE="UPDATE_PROFILE";
	public static final String ON_US="ON_US";
	public static final String OFF_US="OFF_US";
	public static final String REQ_KEY_CARDNUMBER1="REQ_KEY_CARDNUMBER1";
	public static final String REQ_KEY_CARDNUMBER2="REQ_KEY_CARDNUMBER2";
	public static final String DEFAULT_CARD="DEFAULT_CARD";
	public static final String PRE_AUTH_DONE="PRE_AUTH_DONE";
	public static final String PRE_AUTH_NOT_DONE="PRE_AUTH_NOT_DONE";
	public static final String PRE_AUTH_FLAG="PRE_AUTH_FLAG";

	public static final String RETRIEVAL_REQUEST_RAISED="RETRIEVAL_REQUEST_RAISED";
	public static final String CHARGEBACK_RAISED="CHARGEBACK_RAISED";
	public static final String SECOND_CHARGEBACK_RAISED="SECOND_CHARGEBACK_RAISED";
	public static final String READY_FOR_POSTING="READY_FOR_POSTING";
	public static final String READY_FOR_REVERSAL="READY_FOR_REVERSAL";
	public static final String CLOSED="CLOSED";
	public static final String ARBITRATION="ARBITRATION";

	/*Newly Replaced file constant*/
	/*Begining of Move Fund Constants*/

	public static final String PRIMARY_CARD_TYPE="PRIMARY_CARD_TYPE";
	public static final String PRIMARY_CODE="PRIMARY_CODE";
	public static final String SECONDARY_CARD_TYPE="SECONDARY_CARD_TYPE";
	public static final String SECONDARY_CODE="SECONDARY_CODE";
	public static final String OWN_PRIMARY_CODE="OWN_PRIMARY_CODE";
	public static final String OWN_CLIENT_PRIMARY_CODE="OWN_CLIENT_PRIMARY_CODE";
	public static final String REGISTERED_PRIMARY_CODE="REGISTERED_PRIMARY_CODE";
	public static final String OWN_SECONDARY_CODE="OWN_SECONDARY_CODE";
	public static final String OWN_CLIENT_SECONDARY_CODE="OWN_CLIENT_SECONDARY_CODE";
	public static final String REGISTERED_SECONDARY_CODE="REGISTERED_SECONDARY_CODE";
	public static final String TYPE_REQUEST_MSG = "TYPE_REQUEST_MSG";
    public static final String TYPE_RESPONSE_MSG = "TYPE_RESPONSE_MSG";
    
    public static final String REQ_KEY_FROM_ACCOUNT_AMOUNT = "REQ_KEY_FROM_ACCOUNT_AMOUNT";    
    public static final String REQ_KEY_FROM_ACCOUNT_CURRENCY = "REQ_KEY_FROM_ACCOUNT_CURRENCY";
    public static final String REQ_KEY_TO_ACCOUNT_AMOUNT = "REQ_KEY_TO_ACCOUNT_AMOUNT";
    public static final String REQ_KEY_TO_ACCOUNT_CURRENCY = "REQ_KEY_TO_ACCOUNT_CURRENCY";

    /* Ending of Move Fund Constants */

    
    /* Payment Gateway Constants */
	public static final String REQ_KEY_PAYGATEWAY_PURCHASE="REQ_KEY_PAYGATEWAY_PURCHASE";
    
    /* Ending of Payment Gateway Constants */
	
    public static final String MSG_PIN_CHANGED_SUCCESSFULLY = "MSG_PIN_CHANGED_SUCCESSFULLY";
    public static final String MSG_TRANSACTION_DONE_SUCCESSFULLY = "MSG_TRANSACTION_DONE_SUCCESSFULLY";
    
    /**
     * Added by VaibhavB
     * For Card Details validation and Card 2 card FundTransfer
     *  @since Ver. 1.0.0.1 - vaibhavb, bugno#4390, Date 19-Feb-2014
     */
    public static final String REQ_KEY_PARTICULARS  = "PARTICULARS";
    public static final String REQ_KEY_PIN2  = "REQ_KEY_PIN2";
    public static final String REQ_KEY_CARDTOCARDFUNDTRANSFER  = "REQ_KEY_CARDTOCARDFUNDTRANSFER";
    public static final String REQ_KEY_VALIDATECARDDETAILS  = "REQ_KEY_VALIDATECARDDETAILS";
    public static final String SUCCESS_CARDTOCARDFUNDTRANSFER  = "000";
    public static final String SUCCESS_CARDVALIDATION  = "000";
    public static final String REQ_KEY_STAN  = "REQ_KEY_STAN";
    public static final String REQ_PREFERENCE_NUMBER  = "REQ_PREFERENCE_NUMBER";
    public static final String REQ_CARDFUNDTRANSAMT  = "REQ_CARDFUNDTRANSAMT";
    
    public static final String DEFAULT_PIN2_OFFSET="DEFAULT_PIN2_OFFSET";
    
    //Added By Chetan, wrt Issue #4770 ,as on 17 Mar 2014
    public static final String IS_SSM="SSM";

    /**
     * Added by Chetan
     * For Defualt Acquirer inst code and product code
     * @since Ver. 1.0.0.1 - chetan, bugno#4390, Date 24-Feb-2014
     */
    public static final String DEFAULT_ACQUIRE_INST_CODE="DEFAULT_ACQUIRE_INST_CODE";
    public static final String DEFAULT_ACQUIRE_PRODUCT_CODE="DEFAULT_ACQUIRE_PRODUCT_CODE";
    
    //Added by Chetan w.r.t Issue #5703 as on 06 June 2014
    public static final String REQ_DEFAULT_ACCOUNT="REQ_DEFAULT_ACCOUNT";
    
    //Added by Souraf, w.r.t Issue #11194 as on 21 Apr 2015
    public static final String REQ_KEY_PRODUCT_CODE = "REQ_KEY_PRODUCT_CODE";
    
    private static Properties properties = null;
	private static DatavsnConstant instance = new DatavsnConstant();
	private DatavsnConstant() {
		try {
			properties = new Properties();
			properties.load(new FileInputStream("./q2/cfg/DatavsnConstants.properties"));
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static DatavsnConstant getInstance(){
		return instance;
	}

	public static String getConstant(String keyCode){
		return getProperty(keyCode).trim();
	}

	public static String getProperty(String key){
		if(key==null)
			return null;
		return properties.getProperty(key);
	}
}
