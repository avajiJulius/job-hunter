package com.jobhunter.net;

import java.io.*;
import java.net.Socket;

public class Client {

    public static void main(String[] args) {
        for(int i = 0; i < 100; i++) {
            SimpleClient sc = new SimpleClient();
            sc.start();
        }
    }


}

class SimpleClient extends Thread {

    public void run() {
        sendRequest();
    }

    private static void sendRequest() {
        try {
            Socket socket = new Socket("127.0.0.1", 17711);
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            String name = "Alexandr";
            bw.write(name);
            bw.newLine();
            bw.flush();

            String answer = br.readLine();
            System.out.println("Get answer: " + answer);

            br.close();
            bw.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
