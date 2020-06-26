package com.jobhunter.net;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(17711);

        while(true) {
            Socket client = socket.accept();

            client.close();
        }
    }
}
