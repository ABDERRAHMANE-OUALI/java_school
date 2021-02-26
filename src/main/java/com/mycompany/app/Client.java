package com.mycompany.app;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Client
 */
public class Client {

    private Socket socketClient;
    private String port;
    private PrintWriter out;
    private BufferedReader in;

    public Client(String port) {
        this.port = port;
    }

    public void Connect() {
        this.socketClient = new Socket("localhost", this.port);
    }

    public String sendMessage(String msg) {
        try {
            this.out.print(msg);
            String response = in.readLine();
            return response;
        } catch (Exception e) {
            return null;
        }
    }
}