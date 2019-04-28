package com.en.datavsn.EFTswitch.hsm;

import com.en.datavsn.EFTswitch.codec.DummyField;
import com.en.datavsn.EFTswitch.codec.FixedBinaryField;
import com.en.datavsn.EFTswitch.codec.FixedField;
import com.en.datavsn.EFTswitch.codec.IField;
import com.en.datavsn.EFTswitch.codec.Parser;
import com.en.datavsn.EFTswitch.codec.SwitchField;
import com.en.datavsn.EFTswitch.codec.TField;
import com.en.datavsn.EFTswitch.hsmutil.MapList;

public class AbstractParser {

	public Parser getParser(IField... names) {
    Parser parser=new Parser();
  	   for (IField field : names) {
           parser.add(field);
        }
    return parser;
    }
	public IField UBInt16(String name){
		return new FixedField(name,2);
	}
	public IField UBString(String name,int len){
		return new FixedField(name,len);
	}
	public IField UBStringBinary(String name,int len){
		return new FixedBinaryField(name,len);
	}
	public IField dummy(){
		return new DummyField();
	}
	public IField TString(String name,int len){
		return new TField(name,len);
	}
	public IField Switch(String key,Object... names){
		return new SwitchField(key,names);
	}
	
	public MapList parse(String msg){
		MapList list=new MapList();
		
		return list;
	}
}
