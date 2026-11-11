package cr.utn.descuento;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/** Casos CP-01 a CP-09 de la matriz de trazabilidad (Desarrollo A, secc. 5). */
class CalculadoraDescuentoTest {

    private static final double TOLERANCIA = 0.0001;

    private CalculadoraDescuento calculadora;

    @BeforeEach
    void preparar() {                       // Arrange compartido: objeto nuevo en cada prueba
        calculadora = new CalculadoraDescuento();
    }

    @Test
    @DisplayName("CP-01 normal: monto por debajo del umbral no recibe descuento")
    void cp01MontoNormalSinDescuento() {
        double monto = 50.0;                                          // Arrange
        double total = calculadora.calcularTotal(monto);              // Act
        assertEquals(50.0, total, TOLERANCIA);                        // Assert
    }

    @Test
    @DisplayName("CP-02 límite: monto exacto en el umbral recibe 10 %")
    void cp02MontoEnElUmbralRecibeDescuento() {
        double total = calculadora.calcularTotal(100.0);
        assertEquals(90.0, total, TOLERANCIA);
    }

    @Test
    @DisplayName("CP-03 límite: justo debajo del umbral no recibe descuento")
    void cp03MontoJustoDebajoDelUmbral() {
        double total = calculadora.calcularTotal(99.99);
        assertEquals(99.99, total, TOLERANCIA);
    }

    @Test
    @DisplayName("CP-04 error: monto negativo lanza excepción")
    void cp04MontoNegativoLanzaExcepcion() {
        assertThrows(IllegalArgumentException.class, () -> calculadora.calcularTotal(-1.0));
    }

    @Test
    @DisplayName("CP-08 límite/error: -0,01 lanza excepción")
    void cp08JustoDebajoDeCeroLanzaExcepcion() {
        assertThrows(IllegalArgumentException.class, () -> calculadora.calcularTotal(-0.01));
    }

    @ParameterizedTest(name = "{0}: monto {1} -> total {2}")
    @CsvSource({
        "CP-05, 200.00, 180.00",
        "CP-06, 0.00,   0.00",
        "CP-07, 100.01, 90.01",
        "CP-09, 0.01,   0.01"
    })
    @DisplayName("CP-05, CP-06, CP-07 y CP-09: varios valores con el mismo molde AAA")
    void variosCasos(String id, double monto, double esperado) {
        assertEquals(esperado, calculadora.calcularTotal(monto), TOLERANCIA);
    }
}
