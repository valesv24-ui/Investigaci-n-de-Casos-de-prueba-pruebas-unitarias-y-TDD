package cr.utn.descuento;

/**
 * Estado final del ciclo (después del REFACTOR).
 * Regla ILUSTRATIVA: 10 % de descuento si el total es >= 100.
 * ⚠ Ajustar umbral y tasa al requisito real de la guía.
 */
public class CalculadoraDescuento {

    static final double UMBRAL = 100.0;
    static final double TASA_DESCUENTO = 0.10;

    public double calcularTotal(double monto) {
        if (monto < 0) {
            throw new IllegalArgumentException("El monto no puede ser negativo");
        }
        return monto >= UMBRAL ? monto * (1 - TASA_DESCUENTO) : monto;
    }
}
