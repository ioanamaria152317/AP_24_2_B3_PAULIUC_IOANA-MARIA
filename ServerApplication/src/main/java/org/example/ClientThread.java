package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientThread extends Thread{

    //comunica cu client socket
    private Socket socket = null;
    public ClientThread (Socket socket) {
        this.socket = socket ;
    }
    public void run () {
        try {
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            String request = in.readLine();

            PrintWriter out = new PrintWriter(socket.getOutputStream());


            if (request.equals("Stop")){
                 out.println("Server stopped!");
            }
            else {
                out.println("Server received the request" + request);
            }

            out.flush();
        } catch (IOException e) {
            System.err.println("Communication error... " + e);
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                System.err.println (e);
            }
        }
    }
}

