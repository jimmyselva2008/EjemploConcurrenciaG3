package com.tuempresa.ejemploconcurrenciag3;

public class Caja {

    private int cantidadVentas = 0;
    private int totalRecaudado = 0;


    /**
     * SYNCHRONIZED permite que solamente Thread (hilo) ejecutre el metodo a la vez
     * Con esto evitamos el problema de race condition
     * @param vendedor es el numero o nombre del vendedor (hilo)
     * @param monto es el monto estimado
     */

    public synchronized void registrarVentas(String vendedor, int monto)
    {
        cantidadVentas++;
        totalRecaudado += monto;

        System.out.println( vendedor + " Registró una venta de C$" + monto + " | ventas acumuladas "
                + cantidadVentas + " | total C$ " + totalRecaudado);


    }

    public int getCantidadVentas() {
        return cantidadVentas;
    }

    public int getTotalRecaudado() {
        return totalRecaudado;
    }
}
