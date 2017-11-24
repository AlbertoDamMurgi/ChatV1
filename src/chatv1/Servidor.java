package chatv1;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;

public class Servidor {

    public static void main(String[] args) {
        ArrayList<Cliente> clientes = new ArrayList<>();
       int id=1;
        try(ServerSocket server = new ServerSocket(50000)) {

            mostrarBanner();

            while (true) {

               new Thread(new ServidorHilo(server.accept(),clientes,id++)).start();
               System.out.println("Cliente Conectado.");
               System.out.println("Numero total de clientes: "+(clientes.size()+1));

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void mostrarBanner() {

        System.out.println("+--------------------------------+");
        System.out.println("|--------------------------------|");
        System.out.println("|--- # Servidor Chat Activo # ---|");
        System.out.println("|---     < Puerto 50000 >     ---|");
        System.out.println("|--------------------------------|");
        System.out.println("+--------------------------------+");


    }


}
