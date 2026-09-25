package cl.dsy1102.fonda;

public class BebidaAlcoholica extends Bebida implements ConsumoResponsable {
    public static final int LIMITE_UNIDADES_POR_CLIENTE = 3;

    private double gradosAlcohol;
    private boolean certificada;
    private boolean ventaRestringida;

    public BebidaAlcoholica(String nombre, int volumenML, int stock, double gradosAlcohol, boolean certificada) {
        super(nombre, volumenML, stock);
        setGradosAlcohol(gradosAlcohol);
        setCertificada(certificada);
        this.ventaRestringida = false;
    }

    public double getGradosAlcohol() {
        return gradosAlcohol;
    }

    public void setGradosAlcohol(double gradosAlcohol) {
        if (gradosAlcohol < 0.5 || gradosAlcohol > 45.0) {
            throw new IllegalArgumentException("Los grados de alcohol deben estar entre 0.5 y 45.");
        }
        this.gradosAlcohol = gradosAlcohol;
    }

    public boolean isCertificada() {
        return certificada;
    }

    public void setCertificada(boolean certificada) {
        this.certificada = certificada;
    }

    @Override
    public double calcularPrecio() {
        double precioBase = 3500.0;
        if (!certificada) {
            precioBase += precioBase * 0.20;
        }
        return precioBase;
    }

    @Override
    public String obtenerDetalle() {
        String certText = certificada ? "Si" : "No";
        String restText = ventaRestringida ? "Si" : "No";
        return "Tipo: Bebida Alcoholica | Nombre: " + getNombre() +
                " | Volumen: " + getVolumenML() + " ml | Stock: " + getStock() +
                " | Grados: " + gradosAlcohol + " | Certificada: " + certText +
                "\n  Venta restringida: " + restText + " | Precio: $" + (int)calcularPrecio();
    }

    @Override
    public boolean tieneVentaRestringida() {
        return ventaRestringida;
    }

    @Override
    public void restringirVenta() {
        this.ventaRestringida = true;
    }

    @Override
    public boolean superaLimite(int unidades) {
        return unidades > LIMITE_UNIDADES_POR_CLIENTE;
    }
}