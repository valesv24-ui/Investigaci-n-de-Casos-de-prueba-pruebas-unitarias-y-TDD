package cr.utn.descuento;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CalculadoraDescuentoTest {

    private CalculadoraDescuento calculadora;

    @BeforeEach
    void preparar() {                       // Arrange compartido: estado nuevo en cada prueba
        calculadora = new CalculadoraDescuento();
    }

    @Test
    @DisplayName("CP-01 normal: monto por debajo del umbral no recibe descuento")
    void montoNormalSinDescuento() {
        double monto = 50.0;                                  // Arrange
        double total = calculadora.calcularTotal(monto);      // Act
        assertEquals(50.0, total, 0.001);                     // Assert
    }

    @Test
    @DisplayName("CP-02 límite: monto exacto en el umbral recibe 10 %")
    void montoEnElUmbralRecibeDescuento() {
        double total = calculadora.calcularTotal(100.0);
        assertEquals(90.0, total, 0.001);
    }

    @Test
    @DisplayName("CP-03 límite: justo debajo del umbral no recibe descuento")
    void montoJustoDebajoDelUmbral() {
        double total = calculadora.calcularTotal(99.99);
        assertEquals(99.99, total, 0.001);
    }

    @Test
    @DisplayName("CP-04 error: monto negativo lanza excepción")
    void montoNegativoLanzaExcepcion() {
        assertThrows(IllegalArgumentException.class, () -> calculadora.calcularTotal(-1.0));
    }

    @ParameterizedTest(name = "monto {0} -> total {1}")
    @CsvSource({"0, 0", "99.99, 99.99", "100, 90", "100.01, 90.009", "200, 180"})
    @DisplayName("Varios valores en un solo método (particiones y fronteras)")
    void variosValores(double monto, double esperado) {
        assertEquals(esperado, calculadora.calcularTotal(monto), 0.001);
    }
}
