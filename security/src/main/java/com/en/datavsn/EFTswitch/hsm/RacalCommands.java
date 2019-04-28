package com.en.datavsn.EFTswitch.hsm;

import org.jpos.iso.ISOUtil;

import com.en.datavsn.EFTswitch.codec.Parser;
 

public class RacalCommands extends ThalesAdaptor{
	String dec="0123456789012345";
    String vd="0011440000N4";

   public Parser diagnostics() throws Exception {
	   Parser req=new RacalParser().racal();
       req.setValue("command", "NC");
 	   return command(req);
   }
   

   public Parser generateDoubleLengthKey1() throws Exception {
       Parser req=new RacalParser().racal();
       req.setValue("command", "A0");
       req.setValue("mode", "0");
       req.setValue("key-type", "001");
       req.setValue("key-scheme-lmk", "U");
       return command(req);
   }
   public Parser generateTMK()throws Exception{

	   Parser  req = new RacalParser().racal();//("A0");
       req.setValue("command", "A0");
 	   req.setValue("mode", "0");
       req.setValue("key-type", "002");
       req.setValue("key-scheme-lmk", "U");
       return command(req);

       
   }
   public Parser generateMKAC()throws Exception{
       Parser  req = new RacalParser().racal();//("A0");
       req.setValue("command", "A0");
       req.setValue("mode", "0");
       req.setValue("key-type", "109");
       req.setValue("key-scheme-lmk", "U");
       return command(req);

       
   }
   
   public Parser generatePVK(String scheme)throws Exception{
	   Parser  req = new RacalParser().racal();//("A0");
       req.setValue("command", "A0");
    
	   req.setValue("mode", "0");
       req.setValue("key-type", "002");
       req.setValue("key-scheme-lmk", scheme);
       return command(req);
   }
   /*public FSDMsg generatePrintFormat()throws Exception{
       //Print Format
        String format=
                   ">L>013^0"+
                   ">L013^1"+ ">041^P"+
                   ">L013^2"+
                   ">L013^3"+
                   ">L013 THNAK YOU"+
                   ">L"+  //Line Feed
                   ">F"; //Form Feed
                   ;
    //   command("Print Format", cmd);
                   FSDMsg req = createRequest("PA");
                   req.set("format", format);
                   return command(req);

   }*/
   /*public void printPINMailer()throws Exception{
	   String pan="144000006432";
       String format=">L>L>L>L>L>L>L>L>L>025^P>050^0>L>050^1>L>050^2^3^4>L>050^5^6^7>L>L>050^8>064^9>L>050^A>057^B>067^C>077^D>017>L>L>L>L>L>L>L>L>L";
       //command("PrintFormat", cmd);
       FSDMsg req = createRequest("PA");
       req.set("format", format);
       FSDMsg res=command(req);
      
       //cmd="PE"+"C"+pan+"98779";
       String addr="Bharavi G.;Surya NAGAR  ;Old Alwal;; ;Secundrabad;;INDIA;Card Number:;xxxxx64324;Date:;01/07/2011;Pin Code:;560010";
      // command("PinMailer",cmd+addr);
        //0006 PF 00 3018185465422469654315694
       req = createRequest("PE");
       req.set("format","C"+pan+"98779"+addr);
        res=command(req);

      }*/
   public Parser generateIBMPin(String epvk,String pan,String offset) throws Exception{
       
       //String key="U1BD6E6C5AB24D30C9BA150612C3871AB";

	   Parser req=new RacalParser().racal();
       req.setValue("command", "EE");  
       //req.setValue("pvk-type","U");//make this as Constanct Key Scheme
       req.setValue("pvk",epvk);
       req.setValue("offset",offset);//make it as param
       req.setValue("checklength","04");
       req.setValue("account-number",pan);
       req.setValue("dectable",dec);
       req.setValue("pinvaldationdata",vd);
       //String cmd="EE"+epvk+"1235FFFFFFFF"+"04"+pan+dec+vd;
       return command(req);
       
       //Generate IBM PIN
       // EE +PVK(16H)+ OFFSET(12H)+MIN PIN LEN(2N)+ PAN(12N)+dec(16N)+PIN VALIDATION DATA
       
   }
   
   /**
    * generate Pin2 
    * 
    * @param epvk
    * @param pan
    * @param offset
    * @return
    * @throws Exception
    *  @since Ver. 1.0.0.1 - vaibhavb, bugno#4490, Date 24-Feb-2014
    */
   public Parser generateIBMPin2(String epvk,String pan,String offset) throws Exception{
       
       //String key="U1BD6E6C5AB24D30C9BA150612C3871AB";

	   Parser req=new RacalParser().racal();
       req.setValue("command", "EE");  
       //req.setValue("pvk-type","U");//make this as Constanct Key Scheme
       req.setValue("pvk",epvk);
       req.setValue("offset",offset);//make it as param
       req.setValue("checklength","05");
       req.setValue("account-number",pan);
       req.setValue("dectable",dec);
       req.setValue("pinvaldationdata",vd);
       //String cmd="EE"+epvk+"1235FFFFFFFF"+"04"+pan+dec+vd;
       return command(req);
       
       //Generate IBM PIN
       // EE +PVK(16H)+ OFFSET(12H)+MIN PIN LEN(2N)+ PAN(12N)+dec(16N)+PIN VALIDATION DATA
       
   }
   
   /*
    * Required in Change PIN
    * Use this function to get the encrypted pin under LMK
    * then calculate offset for the encrypted pin for storing offset
    */
   public Parser tranlatePIN(String ezpk,String pan,String pb,String format)throws Exception{
	   Parser req=new RacalParser().racal();
       req.setValue("command", "JE");
	  // req.setValue("zpk-type","U");//make this as Constanct Key Scheme
       req.setValue("zpk",ezpk);
       req.setValue("pinblk",pb);
       req.setValue("pinblk-format",format);
       req.setValue("account-number",pan);
       return command(req);
   }
   public Parser generateIBMPinOffset(String epvk,String pan,String epin) throws Exception{
       //Generate IBM PIN OFFSET
       //DE+PVK+PIN(LN or LH)+min PIN LENGTH + DEC TABLE + VALIDATION DATA
       // String cmd="DE"+key+ep+"04"+pan+dec+vd;
       // command("OFFSET",cmd);
       //0238 DF 02 1234FFFFFFFF
       Parser req=new RacalParser().racal();
       req.setValue("command", "DE");
       req.setValue("pvk",epvk);
       req.setValue("epin",epin);//make it as param
       req.setValue("checklength","04");
       req.setValue("account-number",pan);
       req.setValue("dectable",dec);
       req.setValue("pinvaldationdata",vd);
       return command(req);
   }
 
   public Parser verifyInterchangePin(String ezpk,String epvk,String pan,String pb,String format,String offset) throws Exception{
	   
	   Parser req=new RacalParser().racal();
       req.setValue("command", "EA");
	   //req.setValue("zpk-type","U");//make this as Constanct Key Scheme
       req.setValue("zpk",ezpk);
       //req.setValue("pvk-type","U");//make this as Constanct Key Scheme
       req.setValue("pvk",epvk);
       req.setValue("maxpinlength","12");
       req.setValue("pinblk",pb);
       req.setValue("pinblk-format",format);
       req.setValue("checklength","04");
       req.setValue("account-number",pan);
       req.setValue("dectable",dec);
       req.setValue("pinvaldationdata",vd);
       req.setValue("offset",offset);
       return command(req);
   }
   
   public Parser VerifyTerminalPINwithIBMAlgorithm(String ezpk,String epvk,String pan,String pb,String format,String offset) throws Exception{
	   
	   Parser req=new RacalParser().racal();
       req.setValue("command", "DA");
       req.setValue("zpk",ezpk);
       req.setValue("pvk",epvk);
       req.setValue("maxpinlength","12");
       req.setValue("pinblk",pb);
       req.setValue("pinblk-format",format);
       req.setValue("checklength","04");
       req.setValue("account-number",pan);
       req.setValue("dectable",dec);
       req.setValue("pinvaldationdata",vd);
       req.setValue("offset",offset);
       return command(req);
   }

   /**
    * verify IBMPin2 Offset using DA command
    * @param ezpk
    * @param epvk
    * @param pan
    * @param pb
    * @param format
    * @param offset
    * @param pin2Length
    * @return
    * @throws Exception
    * @since ver. 2.0.22-P1 modified by Chetan w.r.t Issue #8514 as on 29-Nov-2014
	* 			<li>added pin length in parameter as pin length may vary</li>
    */
   public Parser VerifyTerminalPIN2withIBMAlgorithm(String ezpk,String epvk,String pan,String pb,String format,String offset, String pin2Length) throws Exception{
	   
	   Parser req=new RacalParser().racal();
       req.setValue("command", "DA");
       req.setValue("zpk",ezpk);
       req.setValue("pvk",epvk);
       req.setValue("maxpinlength","12");
       req.setValue("pinblk",pb);
       req.setValue("pinblk-format",format);
       req.setValue("checklength",pin2Length);
       req.setValue("account-number",pan);
       req.setValue("dectable",dec);
       req.setValue("pinvaldationdata",vd);
       req.setValue("offset",offset);
       return command(req);
   }

   /*
    * CVV Key Pair Generation
    */
   public Parser generateCVKPair() throws Exception{
	   Parser req=new RacalParser().racal();
       req.setValue("command", "AS");
       req.setValue("delim",";");
       req.setValue("reserved","0");
       req.setValue("scheme","0");
       req.setValue("kcv-type","0");
       
       return command(req);
       
   }
   public Parser generateVISACVV(String keya,String keyb,String pan,String exp,String service)throws Exception{
      // String key="C62B3BE16F8E1F61B749C78E1EFB3FEB";
      // String expDate="0909";
      // String serviceCode="000";
      // String cmd="CW"+key+pan+";"+expDate+serviceCode;
      // command("cvv gen", cmd);
	   Parser req=new RacalParser().racal();
       req.setValue("command", "CW");
	   req.setValue("keya",keya);
       req.setValue("keyb",keyb);
       req.setValue("pan",pan);// 12 is fixed length
       req.setValue("delim",";");
       req.setValue("expdate",exp);
       req.setValue("servicecode",service);
       return command(req);
       //0235 CX 00 754
     }
     public Parser verifyVISACVV(String keya,String keyb,String pan,String cvv,String exp,String service)throws Exception{
          
         Parser req=new RacalParser().racal();
         req.setValue("command", "CY");
         req.setValue("keya",keya);
         req.setValue("keyb",keyb);
         req.setValue("cvv",cvv);
         req.setValue("pan",pan);// 12 is fixed length
         req.setValue("delim",";");
         req.setValue("expdate",exp);
         req.setValue("servicecode",service);
         return command(req);
       }
     public Parser generatePVKPair(String ezmk) throws Exception{
    	 Parser req=new RacalParser().racal();
         req.setValue("command", "FG");
         req.setValue("zmk-type","U");
         req.setValue("zmk",ezmk);
         req.setValue("delim",";");
         req.setValue("schemezmk","X");
         req.setValue("schemelmk","U");
         req.setValue("kcvtype","1");
         return command(req);
         
     }
     /*
      * Mode of operation:
    		 0 = Perform ARQC verification only
    		 1 = Perform ARQC Verification and ARPC generation
    		 2 = Perform ARPC Generation only
    	 Identifier of the EMV scheme;
				0 = Visa VSDC or UKIS
				1 = Europay or MasterCard M/Chip
		 IMK  32H or 1+32H
		 IV   for EMV 2000 Application Cryptogram session key derivation(16B)
		 PAN+SEQ  Pre-formatted PAN/PAN Sequence No.(8B)
		 ATC   2B   Application Transaction Counter. 
		          Present for all modes. Any two byte value must be supplied,though it is not used, for Scheme ID = 0.
		 UN    4B  Unpredictable Number.  Present for all modes.  Any four byte value must be supplied, though it is not used, for Scheme ID = 0
		 Transaction Data Length 
		 Transaction Data
		 Delimiter  ;      Only present for Modes 0 and 1.
		 ARQC/TC/AAC    8bytes
		 ARC            2bytes 		
		  test.verifyARQC(mode,SchemeID,imkAC, pan, atc, un, arqc, arc, TransactionData);
			       
      */
     public Parser verifyARQC(String mode,String scheme,String imk,String pan,String atc,String un,String arqc,String arc,String data)throws Exception{
    
    	 Parser req=new RacalParser().racal();
  	      req.setValue("command","KQ"); 
    	  req.setValue("mode",mode);//<!-- 0,1,2 -->
    	  req.setValue("scheme-id",scheme);// <!-- 0,1 -->
    	  req.setValue("MK-AC",imk);
    	  req.setValue("pan",pan);
    	  req.setValue("atc",atc);
    	  req.setValue("un",un);
    	  req.setValue("datalength",(ISOUtil.padleft(Integer.toHexString(data.length()/2),2,'0')).toUpperCase());
    	  req.setValue("txndata",data);
    	  req.setValue("delim",";");
    	  req.setValue("cryptogram",arqc);
    	  req.setValue("arc",arc);
        return command(req);
    	 
     }
     public Parser importZPK(String keyType,String ezmk,String zpk,String keyScheme) throws Exception{
    	   Parser req=new RacalParser().racal();
    	   req.setValue("command","A6");
           req.setValue("key-type",keyType);
           req.setValue("zmk",ezmk);
           req.setValue("key-under-zmk",zpk);
           req.setValue("key-scheme",keyScheme);
           req.setValue("attala","0");
           return command(req);
     }
   
     public Parser decryptPin(String panNumber, String epin) throws Exception{
    	 Parser req=new RacalParser().racal();
         req.setValue("command", "NG");
         req.setValue("account-number",panNumber);
         req.setValue("epin",epin);
         return command(req);
         
     }
     public Parser generateCustSelectPin(String ezpk, String epvk,String pan,String pb, String format) throws Exception{
    	   Parser req=new RacalParser().racal();
           req.setValue("command", "BK");  
           req.setValue("key-type", "001");
           req.setValue("zpk",ezpk);
           req.setValue("pvk",epvk);
           req.setValue("pinblk",pb);
           req.setValue("pinblk-format",format);
           req.setValue("checklength","04");
           req.setValue("account-number",pan);
           req.setValue("dectable",dec);
           req.setValue("pinvaldationdata",vd);
           return command(req);
       }
     
     public Parser generateDefaultPVK()throws Exception{
  	   Parser  req = new RacalParser().racal();//("A0");
         req.setValue("command", "A0");
         req.setValue("mode", "0");
         req.setValue("key-type", "002");
         req.setValue("key-scheme-lmk", "Z");
         return command(req);
     }
     
     public Parser generateZPK(String ezmk, String scheme) throws Exception{
  	   Parser req=new RacalParser().racal();
         req.setValue("command", "IA");  
         req.setValue("ezmk",ezmk);
         //req.setValue("attala","0");
         req.setValue("delim",";");
         req.setValue("key-scheme-zmk","X");
         req.setValue("key-scheme-lmk","U");
         req.setValue("check-type","1");
         return command(req);
     }
     
     public Parser transPinZPK1toZPK2(String ezpk1, String ezpk2, String pan, String pinblk, String format1, String format2) throws Exception{
  	   Parser  req = new RacalParser().racal();//("JG");
         req.setValue("command", "CC");
         req.setValue("ezpk1", ezpk1);
         req.setValue("ezpk2", ezpk2);
         req.setValue("max-pin-len", "12");
         req.setValue("pinblk1", pinblk);
         req.setValue("pinblk-format1", format1);
         req.setValue("pinblk-format2", format2);
         req.setValue("account-number",pan);
         return command(req);
     }
  
     public Parser translatePinLMKtoZPK(String ezpk,String pinFormat,String accountNumber,String pin)throws Exception{
  	   Parser  req = new RacalParser().racal();
  	   req.setValue("command", "JG");
         req.setValue("zpk", ezpk);
         req.setValue("pinblk-format",pinFormat);
         req.setValue("account-number",accountNumber);
         req.setValue("pinblk",pin);
         return command(req);
     }
     
     public Parser translatePinTPKtoLMK(String ezpk,String pinFormat,String accountNumber,String pin)throws Exception{
  	   Parser  req = new RacalParser().racal();
  	   req.setValue("command", "JC");
         req.setValue("tpk", ezpk);
         req.setValue("pinblk",pin);
         req.setValue("pinblk-format",pinFormat);
         req.setValue("account-number",accountNumber);
         return command(req);
   }
     
   public Parser generateTMKTPK(String ezmk) throws Exception{
     	   Parser req=new RacalParser().racal();
            req.setValue("command", "HC");  
            req.setValue("ezmk",ezmk);
            req.setValue("delim",";");
            req.setValue("key-scheme-zmk","X");
            req.setValue("key-scheme-lmk","U");
            req.setValue("check-type","1");
            return command(req);
   }
   
   /**
    * EncryptPin using BA comand
    * @param panNumber
    * @param pin
    * @return
    * @throws Exception
	* Added by chetan wrt Issue #5066 as on 19-Apr-2014
    */
   public Parser encryptPin(String panNumber, String pin) throws Exception{
  	 Parser req=new RacalParser().racal();
       req.setValue("command", "BA");
       req.setValue("pin",pin);
       req.setValue("account-number",panNumber);
       return command(req);
   }
   
   /**
    * generate IBMPin2 Offset using DE comand
    * @param epvk
    * @param pan
    * @param epin
    * @return
    * @throws Exception
    * @since ver. 2.0.22-P1 modified by Chetan w.r.t Issue #8514 as on 29-Nov-2014
	* 			<li>added pin length in parameter as pin length may vary</li>
	* Added by chetan wrt Issue #5066 as on 19-Apr-2014
    */
   public Parser generateIBMPin2Offset(String epvk,String pan,String epin, String len) throws Exception{
       Parser req=new RacalParser().racal();
       req.setValue("command", "DE");
       req.setValue("pvk",epvk);
       req.setValue("epin",epin);//make it as param
       req.setValue("checklength", len);
       req.setValue("account-number",pan);
       req.setValue("dectable",dec);
       req.setValue("pinvaldationdata",vd);
       return command(req);
   }
   
    public Parser generateCustSelectPinByTPK(String eTpk, String epvk,String pan,String pb, String format) throws Exception{
  	   Parser req=new RacalParser().racal();
         req.setValue("command", "BK");  
         req.setValue("key-type", "002");
         req.setValue("zpk",eTpk);
         req.setValue("pvk",epvk);
         req.setValue("pinblk",pb);
         req.setValue("pinblk-format",format);
         req.setValue("checklength","04");
         req.setValue("account-number",pan);
         req.setValue("dectable",dec);
         req.setValue("pinvaldationdata",vd);
         return command(req);
     }
     
     /**
      * this method generate offset for pin2 as per customer selected pin
      * @param eTpk
      * @param epvk
      * @param pan
      * @param pb
      * @param format
      * @param pin2Length
      * @return
      * @throws Exception
      * @since ver. 2.0.22-P1 modified by Chetan w.r.t Issue #8514 as on 29-Nov-2014
      * 			<li>added pin length in parameter as pin length may vary</li>
      */
     public Parser generateCustSelectPin2ByTPK(String eTpk, String epvk,String pan,String pb, String format, String pin2Length) throws Exception{
    	   Parser req=new RacalParser().racal();
           req.setValue("command", "BK");  
           req.setValue("key-type", "002");
           req.setValue("zpk",eTpk);
           req.setValue("pvk",epvk);
           req.setValue("pinblk",pb);
           req.setValue("pinblk-format",format);
           req.setValue("checklength", pin2Length);
           req.setValue("account-number",pan);
           req.setValue("dectable",dec);
           req.setValue("pinvaldationdata",vd);
           return command(req);
       }
}
