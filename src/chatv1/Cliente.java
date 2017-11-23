package chatv1;

import java.io.BufferedReader;
import java.io.PrintWriter;

public class Cliente {

    private String nombre;
    private BufferedReader entrada;
    private PrintWriter salida;

    public Cliente(String nombre, BufferedReader entrada, PrintWriter salida) {
        this.nombre = nombre;
        this.entrada = entrada;
        this.salida = salida;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BufferedReader getEntrada() {
        return entrada;
    }

    public void setEntrada(BufferedReader entrada) {
        this.entrada = entrada;
    }

    public PrintWriter getSalida() {
        return salida;
    }

    public void setSalida(PrintWriter salida) {
        this.salida = salida;
    }
}
