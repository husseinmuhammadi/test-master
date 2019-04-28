package com.en.datavsn.EFTswitch.codec;

import com.en.datavsn.EFTswitch.hsmutil.MapList;


public interface IField
{
	public abstract byte[] pack();
	public abstract int unpack(byte[] message);
	public abstract int unpack(byte[] message, int position);
	public abstract String getName();
	public abstract void setValueMap(MapList valueMap);

}