package com.mycompany.app;

import java.io.*;
import java.net.*;
import java.util.Scanner;

import javax.sound.sampled.Line;

/**
 * Server
 */
public class Server {
    private ServerSocket serversocket;
    private Socket socket;
    private int port;
    private DataInputStream in;
    private PrintWriter out;
    private Scanner scanner;

    public Server(int port) {
        try {
            ServerSocket ss = new ServerSocket(this.port);
            Socket s = ss.accept();

            
            DataInputStream din = new DataInputStream(s.getInputStream());
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            String str = "", str2 = "";
            while (!str.equals("stop")) {
                str = din.readUTF();
                System.out.println("client says: " + str);
                str2 = br.readLine();
                dout.writeUTF(str2);
                dout.flush();
            }
            din.close();
            s.close();
            ss.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public static void main(String[] args) {
        Server serverSocket = new Server(3000);
    }
}