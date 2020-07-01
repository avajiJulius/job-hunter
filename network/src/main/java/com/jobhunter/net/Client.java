package com.jobhunter.net;

import java.io.*;
import java.net.Socket;

public class Client {

    public static void main(String[] args) {
        for(int i = 0; i < 8; i++) {
            SimpleClient sc = new SimpleClient(i);
            sc.start();
        }
    }


}

class SimpleClient extends Thread {

    private static final String[] COMMAND = {
            "HELLO", "MORNING", "DAY", "EVENING"
    };

    private int cmdNumber;

    public SimpleClient(int cmdNumber) {
        this.cmdNumber = cmdNumber;
    }

    public void run() {
        sendRequest();
    }

    private void sendRequest() {
        try {
            Socket socket = new Socket("127.0.0.1", 17711);
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            String command = COMMAND[cmdNumber % COMMAND.length];
            String sb = command + " Alexandr";
            bw.write(sb);
            bw.newLine();
            bw.flush();

            String answer = br.readLine();
            System.out.println(answer);

            br.close();
            bw.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
