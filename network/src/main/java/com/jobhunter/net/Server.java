package com.jobhunter.net;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(17711, 200);
        System.out.println("Server is started");

        while (true) {
            Socket client = socket.accept();
            new SimpleServer(client).start();
        }


    }
}

class SimpleServer extends Thread {

    private Socket client;

    public SimpleServer(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        handleRequest();
    }

    private void handleRequest() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));


            StringBuilder str = new StringBuilder("Hello, ");
            String userName = reader.readLine();
            System.out.println("Get from client: " + userName);

            str.append(userName);
            writer.write(str.toString());
            writer.newLine();
            writer.flush();


            client.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

