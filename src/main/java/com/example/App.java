package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
public class App 
{
    public static void main( String[] args )
    {
        try {
            System.out.println("Server avviato");
            ServerSocket server = new ServerSocket(3000);
            
            Integer numeroBiglietti = 5;

            while (true) {
                Socket s = server.accept();

                System.out.println("Il client si è connesso");
                
                NuovoThread t1 = new NuovoThread(s, numeroBiglietti);
                t1.start();                
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Errore durante l'istanza");
            System.exit(1);
        }
       


    }
}
