package chatv1;

import java.util.ArrayList;
import java.util.Scanner;

public class ServidorEscribir implements Runnable {

    private ArrayList<Cliente> clientes;

    public ServidorEscribir(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    private void enviar(String cadena){
        for (Cliente c : clientes) {

            c.getSalida().println("<[Servidor]>"+cadena);

        }
    }

    @Override
    public void run() {
        Scanner teclado = new Scanner(System.in);
        String cadena;
        while(true){
            cadena=teclado.nextLine();

            if(cadena.equalsIgnoreCase("exit")||cadena.equalsIgnoreCase("quit")){
                System.out.println("Cerrando servidor..");
                cadena="El servidor ha sido cerrado..";
                enviar(cadena);
                System.exit(0);

            }

            enviar(cadena);
        }
    }
}
