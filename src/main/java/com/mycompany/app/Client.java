package com.mycompany.app;

import java.io.*;
import java.net.*;

/**
 * Client
 */
public class Client {
    private Socket socket;
    private int port;
    private String ip;
    private DataInputStream input;
    private DataOutputStream out;

    public static void main(String[] args) {
        Client clientSocket = new Client("localhost", 3000);
    }

    public Client(String ip, int port) {
        this.ip = ip;
        this.port = port;
        try {
            Socket s = new Socket(this.ip, this.port);
            DataInputStream din = new DataInputStream(s.getInputStream());
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            String str = "", str2 = "";
            while (!str.equals("stop")) {
                str = br.readLine();
                dout.writeUTF(str);
                dout.flush();
                str2 = din.readUTF();
                System.out.println("Server says: " + str2);
            }

            dout.close();
            s.close();

        } catch (Exception e) {
            System.out.println("Server Close Connection");
        }

    }
}