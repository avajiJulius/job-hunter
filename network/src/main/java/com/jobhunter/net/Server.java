package com.jobhunter.net;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Server {

    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(17711, 200);

        Map<String, Greatable> handlers = loadHandlers();

        System.out.println("Server is started");
        while (true) {
            Socket client = socket.accept();
            new SimpleServer(client, handlers).start();
        }


    }

    private static Map<String, Greatable> loadHandlers() {
        Map<String, Greatable> result = new HashMap<>();

        try(InputStream is = Server.class.getClassLoader().getResourceAsStream("server.properties")) {

            Properties properties = new Properties();
            properties.load(is);

            for(Object cmd : properties.keySet()) {
                String className = properties.getProperty(cmd.toString());
                Class<Greatable> cl = (Class<Greatable>) Class.forName(className);

                Greatable handler = cl.getConstructor().newInstance();
                result.put(cmd.toString(), handler);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
        return result;
    }
}

class SimpleServer extends Thread {

    private Socket client;
    private Map<String, Greatable> handlers;

    public SimpleServer(Socket client, Map<String, Greatable> handlers) {
        this.client = client;
        this.handlers = handlers;
    }

    @Override
    public void run() {
        handleRequest();
    }

    private void handleRequest() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));

            String request = reader.readLine();
            String[] lines = request.split("\\s+");
            String command = lines[0];
            String userName = lines[1];

            String response = buildResponse(command, userName);
            writer.write(response);
            writer.newLine();
            writer.flush();

            reader.close();
            writer.close();

            client.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private String buildResponse(String command, String userName) {
        Greatable handler = handlers.get(command);
        if(handler != null)
            return handler.buildResponse(userName);
        return "Hi " + userName;
    }
}

