package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.rmi.UnknownHostException;

public class GameClient {

    //citeste comenzi de la tastatura si le trimite server ului
    //+se opreste cand citeste EXIT

    public static void main (String[] args) throws IOException {
        String serverAddress = "127.0.0.1";
        int PORT = 8100;
        try (
                Socket socket = new Socket(serverAddress, PORT);
                PrintWriter out =
                        new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));
                BufferedReader playerInput=new BufferedReader(new InputStreamReader(System.in))
        ) {
            // Send a request to the server
            String request;
            System.out.println("Enter your request ( TYPE 'EXIT' TO QUIT):");

            while(true){
                request=playerInput.readLine();

                if (request.equals("EXIT")){
                    System.out.println("Nu ma mai vrea...");
                    out.println("Clientul s-a suparat");
                    break;
                }
                //create game, join game, submit move

                out.println(request); //trimit server ului

                String response = in.readLine ();
                System.out.println("Server:" + response);
            }

        } catch (UnknownHostException e) {
            System.err.println("No server listening... " + e);
        }
    }

}
