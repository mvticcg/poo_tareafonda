package cl.dsy1102.fonda;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        GestorFonda gestor = new GestorFonda();

        // 1 instanciar bebidas
        BebidaAlcoholica chichaAlc = new BebidaAlcoholica("Chicha", 1000, 40, 12.0, false);
        BebidaAlcoholica piscoSour = new BebidaAlcoholica("Pisco Sour", 500, 25, 18.0, true);
        BebidaSinAlcohol chichaSin = new BebidaSinAlcohol("Chicha", 1000, 60, 95);
        BebidaSinAlcohol mote = new BebidaSinAlcohol("Mote con Huesillo", 400, 50, 70);

        // 2 marcar la chicha q cura con la venta restringida
        chichaAlc.restringirVenta();

        // 3 registrar todas en el gestor
        gestor.registrar(chichaAlc);
        gestor.registrar(piscoSour);
        gestor.registrar(chichaSin);
        gestor.registrar(mote);

        System.out.println();

        // 5 acá busca por el nombre "Chicha"
        System.out.println("=== BUSQUEDA POR NOMBRE: \"Chicha\" ===");
        List<Bebida> busqueda = gestor.buscarPorNombre("Chicha");
        for (Bebida b : busqueda) {
            System.out.println(b.obtenerDetalle());
            System.out.println("---");
        }

        System.out.println();

        // 4 solicita ventas
        System.out.println("=== VENTAS ===");
        gestor.vender("Pisco Sour", 2);
        gestor.vender("Pisco Sour", 5);
        gestor.vender("Chicha", 1);
        gestor.vender("Mote con Huesillo", 6);

        System.out.println();

        // listar todas las bebidas mediante toString() jejej
        System.out.println("=== LISTADO DE BEBIDAS ===");
        for (Bebida b : gestor.obtenerTodas()) {
            System.out.println(b);
        }
    }
}