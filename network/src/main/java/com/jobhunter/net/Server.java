package com.jobhunter.net;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(17711);
        System.out.println("Server is started");

        while(true) {
            try {
                Socket client = socket.accept();
                handelRequest(client);

            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    private static void handelRequest(Socket client) throws IOException {
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));) {


            StringBuilder str = new StringBuilder("Hello, ");
            String userName = reader.readLine();
            System.out.println("Get from client: " + userName);

            str.append(userName);
            writer.write(str.toString());
            writer.newLine();
            writer.flush();

        } catch (IOException ex) {

        } finally {
            client.close();
        }
    }
}
