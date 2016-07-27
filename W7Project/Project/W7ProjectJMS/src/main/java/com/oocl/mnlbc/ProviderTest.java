package com.oocl.mnlbc;

import com.oocl.mnlbc.provider.Provider;

public class ProviderTest {

	public static Integer ctr = new Integer(0);

	public static void main(String[] args) {
		Provider provider = new Provider();
		provider.sendMessage("Provider " + (ctr++).toString());
		provider.sendMessage("Provider " + (ctr++).toString());
		provider.sendMessage("Provider " + (ctr++).toString());
		provider.sendMessage("Provider " + (ctr++).toString());
		provider.sendMessage("Provider " + (ctr++).toString());
	}

}
