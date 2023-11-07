package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class NuovoThread extends Thread{
    private Socket s;
    private Integer numeroBiglietti;

    public NuovoThread (Socket s, Integer numeroBiglietti) {
        this.s = s;
        this.numeroBiglietti = numeroBiglietti;
    }

    public void run () {
        try {

            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            DataOutputStream out = new DataOutputStream(s.getOutputStream());

            String stringaRicevuta = "";

            do {
                stringaRicevuta = in.readLine();
                System.out.println(Thread.currentThread().getName() + " ha digitato " + stringaRicevuta);
                
                if (stringaRicevuta.equals("D")) {
                    out.writeBytes(numeroBiglietti + "\n");
                } 
                
                else if (stringaRicevuta.equals("A")) {
                    numeroBiglietti--;
                    out.writeBytes(numeroBiglietti + "\n");
                }
            } while (numeroBiglietti != 0 || !stringaRicevuta.equals("Q"));
              
            s.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Errore durante l'istanza");
            System.exit(1);
        }
    }
}
