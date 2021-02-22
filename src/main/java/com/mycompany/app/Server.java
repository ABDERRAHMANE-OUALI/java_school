package com.mycompany.app;

import java.net.*;
import java.io.*;

class MyServer {
    public static void main(String args[]) throws Exception {
        ServerSocket ss = new ServerSocket(3333);
        Socket s = ss.accept();
        DataInputStream din = new DataInputStream(s.getInputStream());
        DataOutputStream dout = new DataOutputStream(s.getOutputStream());
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = "", str2 = "";

        while (!str.equals("stop")) {
            str = din.readUTF();
            if (str == "list options") {
                dout.writeUTF(
                        "\n to open connection to mysql database: connectDB \n to stop or close connection: stop \n");
                dout.flush();
            }
            if (str == "connectDB") {
                new MysqlDB().Connect("jdbc:mysql://localhost:3306/sonoo", "root", "root");
            } else {
                System.out.println("client says: " + str);
                str2 = br.readLine();
                dout.writeUTF(str2);
                dout.flush();
            }
        }
        din.close();
        s.close();
        ss.close();
    }
}