package com.oocl.mnlbc;

import com.oocl.mnlbc.consumer.ClientConsumer;

public class ConsumerTest {

	public static void main(String[] args) {
		ClientConsumer clientConsumer = new ClientConsumer();
		System.out.println(clientConsumer.getListener().getAdminMessage());
	}

}
