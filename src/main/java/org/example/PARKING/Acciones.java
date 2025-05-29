package org.example.PARKING;

public interface Acciones {

    static void generar(Ticket ticket){
        System.out.println("Leyendo matrícula...");
        String matricula = "9999ZZZ";
        System.out.println("Matrícula: " + matricula);
        System.out.println("Ticket generado.");
        ticket.setMatricula(matricula);
        ticket.setEstado(Estado.GENERADO);
    }

    static void recoger(){

        System.out.println("BIENVENIDO!");
    }

    static void pagar(){

    }

}
