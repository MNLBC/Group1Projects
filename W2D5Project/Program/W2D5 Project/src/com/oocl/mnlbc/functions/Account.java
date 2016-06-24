package com.oocl.mnlbc.functions;

import java.net.Socket;

public class Account {
	private Socket socket;
	private String name;

	public Account(Socket socket) {
		this.socket = socket;
	}

	public Socket getSocket() {
		return socket;
	}

	public void setSocket(Socket socket) {
		this.socket = socket;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
