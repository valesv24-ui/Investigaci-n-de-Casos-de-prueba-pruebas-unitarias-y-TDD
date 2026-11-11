package cr.utn.descuento;

/**
 * R-01: el sistema aplica un descuento del 10 % a las compras de 100 o más.
 * Supuestos (ver Desarrollo A): 100 sí recibe descuento (A1), los negativos
 * son inválidos (A7) y el total se redondea a dos decimales (A3, CA-04).
 */
public class CalculadoraDescuento {

    static final double UMBRAL = 100.0;
    static final double TASA_DESCUENTO = 0.10;

    public double calcularTotal(double monto) {
        if (monto < 0) {
            throw new IllegalArgumentException("El monto no puede ser negativo");
        }
        double total = monto >= UMBRAL ? monto * (1 - TASA_DESCUENTO) : monto;
        return redondearADosDecimales(total);
    }

    private double redondearADosDecimales(double valor) {
        return Math.round(valor * 100.0) / 100.0;
    }
}
