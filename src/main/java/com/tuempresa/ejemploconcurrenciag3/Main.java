package com.tuempresa.ejemploconcurrenciag3;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        // Objeto compartido por todos los Threads
        Caja caja = new Caja();

        //Runanble representa la tarea que ejecutará cada uno de los vendedores
        Runnable vendedor1 = () -> procesarVentas("Vendedor 1", caja);
        Runnable vendedor2 = () -> procesarVentas("Vendedor 2", caja);
        Runnable vendedor3 = () -> procesarVentas("Vendedor 3", caja);

        // Creacion de los Threads (Hilos)
        Thread hilo1 = new Thread(vendedor1);
        Thread hilo2 = new Thread(vendedor2);
        Thread hilo3 = new Thread(vendedor3);

        System.out.println("---- Inicio del proceso de ventas ----");

        /**
         * Start() es el encargado de iniciar el proceso del Hilo
         * los 3 hilos comienzan a procesar sus ventas concurrentemente
         */

        hilo1.start();
        hilo2.start();
        hilo3.start();

        /**
         * join() permite que el hilo main espere el proceso
         * hasta que terminan los otros Threads
         */

        hilo1.join();
        hilo2.join();
        hilo3.join();

        System.out.println("---- Termina del proceso de ventas ----");
        System.out.println("Cantidad de ventas: " + caja.getCantidadVentas());
        System.out.println("Total recaudado: C$" + caja.getTotalRecaudado());

    }

    /**
     * Método que simula las ventas realizadas por cada vendedor
     * @param vendedor
     * @param caja
     */

    private static void procesarVentas(String vendedor, Caja caja) {
        //Simulado de ventas por cada vendedor
        for (int i = 1; i <= 60; i++) {
            try {
                Thread.sleep(10);
                caja.registrarVentas(vendedor, 100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println(vendedor + " fue interrumpido");
                return;
            }
        }
    }
}


