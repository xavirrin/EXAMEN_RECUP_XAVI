package org.example.PARKING;

import java.util.Scanner;

import static org.example.PARKING.Parking.*;

public class AppParking {

    static Parking parking = new Parking("Mutxamel Centro", 1000, 0.025);

    public static void main(String[] args) {

        parking.generarClientesAleatorios();
        parking.mostrarClientesActuales();

        System.out.println();
        app1();

        System.out.println();
        app2();
    }


    static void app1() {

        System.out.println("*** APP ACCESO ***");
        int plazas_libres = parking.getPlazas_totales() - clientesActuales.size();
        if (plazas_libres > 0){
            System.out.println("LIBRE (" + plazas_libres + " plazas libres).");
        } else{
            System.out.println("COMPLETO.");
        }
        System.out.println();

        Ticket ticket = new Ticket("", 1, Estado.PENDIENTE);
        Acciones.generar(ticket);
        parking.anyadirCliente(ticket);
        System.out.println("Recoja su ticket...");
        Acciones.recoger();

        System.out.println();
        mostrarClientesActuales();

    }

    static void app2() {
        Scanner teclado = new Scanner(System.in);

        System.out.println("*** PAGO DE TICKETS ***");
        System.out.println("Introduce tu matrícula:");
        String matricula = teclado.nextLine();
        Ticket ticket = parking.validarTicket(matricula);

        if (ticket != null){
            System.out.println("Minutos: " + ticket.getMinutos() + " - Precio por minuto: " + parking.getPrecio_minuto() + "€");
            System.out.println("Importe a pagar: " + (ticket.getMinutos() * parking.getPrecio_minuto()));
        }else{
            System.out.println("El ticket no existe.");
        }
    }

    static void app3() {
    }


}
