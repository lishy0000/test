package com.succez;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;

public class ResponseImpl {
	private PrintStream outs;

	public ResponseImpl(Socket client) {
		PrintStream outstream = null;
		try {
			outstream = new PrintStream(client.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.outs = outstream;
	}

	public PrintStream GetPrintStream() {
		return outs;
	}

	public void addrequest(String key, int status, String value) {
		outs.print(key);
		outs.print("");
		outs.print(status);
		outs.print("");
		outs.println(value);
	}

	public void addHeader(String key, String value) {
		outs.print(key);
		outs.print(":");
		outs.println(value);
	}

	public void addHeader(String key, int value) {
		outs.print(key);
		outs.print(":");
		outs.println(value);
	}

	public void addBody(String body) {
		outs.println("");
		outs.println(body);

	}

	public void addBody(byte[] body) {
		outs.println("");
		outs.write(body, 0, body.length);
	}

}