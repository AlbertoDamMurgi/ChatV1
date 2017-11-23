package chatv1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class ServidorHilo implements Runnable {


    private Socket tuberia;
    private ArrayList<Cliente> clientes;
    private int id;
    private BufferedReader IN;
    private PrintWriter OUT;
    private Cliente cliente;

    public ServidorHilo(Socket tuberia, ArrayList<Cliente> clientes, int id) {
        this.tuberia = tuberia;
        this.clientes = clientes;
        this.id = id;
    }

    @Override
    public void run() {

        try(
                PrintWriter out = new PrintWriter(tuberia.getOutputStream(),true);
                BufferedReader in = new BufferedReader(new InputStreamReader(tuberia.getInputStream()))

        ) {
            OUT = out;
            IN = in;
            generarCliente(id);
            Scanner teclado = new Scanner(System.in);
            String cadena="";

            mostrarSaludo();

            while (!cadena.trim().equalsIgnoreCase("exit")&&!cadena.trim().equalsIgnoreCase("quit")&&cadena!=null){

                cadena=IN.readLine().trim();

                if(cadena.equalsIgnoreCase("exit")||cadena.equalsIgnoreCase("quit")||cadena==null) break;

                System.out.println("<["+cliente.getNombre()+"]> "+cadena);







            }


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void mostrarSaludo() {

        OUT.println("---------------Bienvenido al servicio de chat!-------------");
        OUT.println("-----------------------------------------------------------");
        OUT.println("-----------------------------------------------------------");
        OUT.println("--------------------Cliente "+id+"-------------------------");
        OUT.println("-----------------------------------------------------------");
        OUT.println("-----------------------------------------------------------");
        OUT.println("-----------------------------------------------------------");
        OUT.println("Total de clientes conectados: "+clientes.size());
    }

    private void generarCliente(int id) {

        cliente = new Cliente("Cliente "+id,IN,OUT);

        clientes.add(cliente);

    }
}
