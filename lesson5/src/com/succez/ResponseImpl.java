package com.succez;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;

public class ResponseImpl {
	private PrintStream outs;
	private String header;

	public ResponseImpl(Socket client) {
		this.header = null;
		PrintStream outstream = null;
		try {
			outstream = new PrintStream(client.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.outs = outstream;
		this.header="";
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
		header = header.concat(key).concat(":").concat(value).concat("\r\n");
	}

	public void addHeader(String key, int value) {

		header = header.concat(key).concat(":")
				.concat(Integer.toString(value).concat("\r\n"));
	}

	public void sendHeader() {
		outs.print(header);
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