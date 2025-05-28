import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GeometriaTest {
	@Test
	void testAreaCuadrado() {
		assertEquals(16, Geometria.areacuadrado(4), "4*4 debería ser 16");
	}
	@Test
	void testAreaTriangulo() {
		assertEquals(9, Geometria.areatriangulo(3, 6), "(3*6)/2 debería ser 18");
	}
	@Test
	void testAreaPenta() {
		assertEquals(10, Geometria.areapentagono(2, 10), "((2*10)/2 debería ser 10");
	}
	@Test
	void testarearomboide() {
		assertEquals(20, Geometria.arearomboide(2, 10), "(2*10 debería ser 10");
	}
	@Test
	void testareatrapecio() {
		assertEquals(25, Geometria.areatrapecio(7, 3, 5), "(((7+3)/2)*5 debería ser 10");
	}
}