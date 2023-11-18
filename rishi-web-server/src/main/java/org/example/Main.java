package org.example;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {
        final Integer portNumber=9191;
        try(ServerSocket serverSocket=new ServerSocket(portNumber)){
            System.out.println("Listening server on port number:"+portNumber);
            while(true){
                Socket socket=serverSocket.accept();
                System.out.println("request accepted");
                PrintWriter writer=new PrintWriter(socket.getOutputStream(),true);
                writer.println("HTTP/1.1 200 OK\r\n\r\nOne!\r\n");
                Thread.sleep(10000);
                writer.println("HTTP/1.1 200 OK\r\n\r\nTwo!\r\n");
                socket.close();

            }
        }
        catch (IOException e){

        }
        catch (Exception e){

        }
        System.out.println("Hello world!");

    }
}