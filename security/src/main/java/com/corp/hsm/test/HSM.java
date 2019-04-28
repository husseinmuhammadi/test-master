package com.corp.hsm.test;

import java.io.IOException;
import java.util.Properties;

import org.jpos.core.ConfigurationException;
import org.jpos.core.SimpleConfiguration;
import org.jpos.iso.packager.DummyPackager;

import com.en.datavsn.EFTswitch.hsm.HSMChannel;

public class HSM {

	public static HSMChannel getHSMChannelInstanse() {
		HSMChannel hsm = new HSMChannel();

		hsm.setHost("172.20.67.2");
		// hsm.setHost("127.0.0.1");
		hsm.setPort(1500);
		hsm.setPackager(new DummyPackager());
		hsm.setHeader("1234".getBytes());
		Properties props = new Properties();
		props.put("schema", "file:cfg/hsm-resp-");

		SimpleConfiguration cfg = new SimpleConfiguration(props);
		try {
			hsm.setConfiguration(cfg);
			hsm.connect();
			return hsm;
		} catch (ConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

}
