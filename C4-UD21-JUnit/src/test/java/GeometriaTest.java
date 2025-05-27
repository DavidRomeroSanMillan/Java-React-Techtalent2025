
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GeometriaTest {
	@Test
	void testAreaCirculo() {
		Geometria prueba = new Geometria();
		assertEquals(16, Geometria.areacuadrado(4), "4*4 debería ser 16");
	}
}
