package org.example.PARKING;

import java.util.*;

public class Parking {

    private String ciudad;
    private int plazas_totales;
    private double precio_minuto;
    public static List<Ticket> clientesActuales;

    public Parking(String ciudad, int plazas_totales, double precio_minuto) {
        this.ciudad = ciudad;
        this.plazas_totales = 1000;
        this.precio_minuto = precio_minuto;
        this.clientesActuales = new LinkedList<>();
    }

        public void generarClientesAleatorios() {

            String letras = "BCDFGHJKLMNPQRSTVWXYZ";
            String numeros = "0123456789";

            Random random = new Random();

            int num_clientes = random.nextInt(10)+1;

            for (int i = 0; i < num_clientes; i++) {
                String matricula = "1234BCD";
                Integer minutos = random.nextInt(240);
                clientesActuales.add(new Ticket(matricula, minutos , Estado.RECOGIDO));
            }

        }

        public static void mostrarClientesActuales() {

            System.out.println("*** PARKING MUTXAMEL ***");
            for (int i = 0; i < clientesActuales.size(); i++) {
                System.out.println((i + 1) + ". " + clientesActuales.get(i));
            }
        }

        public static void anyadirCliente (Ticket ticket){

        clientesActuales.add(ticket);

        }

        public static Ticket validarTicket (String matricula) {
            System.out.println("Validando... ");

            for (int i = 0; i < clientesActuales.size(); i++) {
                if (clientesActuales.get(i).getMatricula() == matricula) {
                    return new Ticket(clientesActuales.get(i).getMatricula(), clientesActuales.get(i).getMinutos(), clientesActuales.get(i).getEstado());
                }else{
                    return null;
                }
            }
        return null;
    }

    public double getPrecio_minuto() {
        return precio_minuto;
    }

    public void setPrecio_minuto(double precio_minuto) {
        this.precio_minuto = precio_minuto;
    }

    public int getPlazas_totales() {
        return plazas_totales;
    }

    public void setPlazas_totales(int plazas_totales) {
        this.plazas_totales = plazas_totales;
    }
}

