package cl.dsy1102.fonda;

import java.util.ArrayList;
import java.util.List;

public class GestorFonda {
    private List<Bebida> bebidas;

    public GestorFonda() {
        this.bebidas = new ArrayList<>();
    }

    public void registrar(Bebida bebida) {
        bebidas.add(bebida);
        System.out.println(bebida.getNombre() + " (" + bebida.getClass().getSimpleName() + ") registrada correctamente.");
    }

    public List<Bebida> buscarPorNombre(String nombre) {
        List<Bebida> resultados = new ArrayList<>();
        for (Bebida b : bebidas) {
            if (b.getNombre().equalsIgnoreCase(nombre)) {
                resultados.add(b);
            }
        }
        return resultados;
    }

    //java m hace pensarmuchoo.............

    public void vender(String nombre, int unidades) {
        for (Bebida b : bebidas) {
            if (b.getNombre().equalsIgnoreCase(nombre)) {
                if (b instanceof ConsumoResponsable) {
                    ConsumoResponsable cr = (ConsumoResponsable) b;
                    if (cr.tieneVentaRestringida()) {
                        System.out.println("Venta rechazada: " + b.getNombre() + " tiene la venta restringida.");
                        return;
                    }
                    if (cr.superaLimite(unidades)) {
                        System.out.println("Venta rechazada: " + unidades + " unidades de " + b.getNombre() + " superan el limite de 3 por cliente.");
                        return;
                    }
                }
                int total = (int) b.calcularPrecio() * unidades;
                System.out.println("Venta autorizada: " + unidades + " x " + b.getNombre() + " | Total: $" + total);
                return;
            }
        }
    }

    public List<Bebida> obtenerTodas() {
        return bebidas;
    }
}