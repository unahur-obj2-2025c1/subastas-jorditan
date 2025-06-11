package ar.edu.unahur.obj2.observer.observables;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.observer.Oferta;
import ar.edu.unahur.obj2.observer.excepciones.OfertaSubastadorException;
import ar.edu.unahur.obj2.observer.observadores.Subastador;
import ar.edu.unahur.obj2.observer.strategys.SubastadorArriesgado;

class ProductoSubatadoTest {
  ProductoSubatado productoSubastado = new ProductoSubatado("Auto BMW");
  Subastador subastador1 = new Subastador("gonzager", new SubastadorArriesgado());
  Subastador subastador2 = new Subastador("martomau", new SubastadorArriesgado());
  Subastador subastador3 = new Subastador("diazdan", new SubastadorArriesgado());

  @BeforeEach
  void setupEscenario1() {
    productoSubastado.reset();
    subastador1.reset();
    subastador2.reset();
    subastador3.reset();

    productoSubastado.agregarObservador(subastador1);
    productoSubastado.agregarObservador(subastador2);

    subastador2.ofertar(productoSubastado);
    subastador1.ofertar(productoSubastado);
    subastador2.ofertar(productoSubastado);
  }

  @Test
  void gonzaegerSabeQueLaUltimaOfertaLaHizoMartumau() {
    assertEquals(subastador1.getUltimaOferta().getSubastador().getNombre(), "martomau");
    assertEquals(subastador2.getUltimaOferta().getSubastador().getNombre(), "martomau");
  }

  @Test 
  void laUltimaOfertaEsDe30Unidades() {
    assertEquals(30, productoSubastado.obtenerUltimaOferta().getMonto());
  }

  @Test
  void elTotalDeOfertasRealizadasEsDe3() {
    assertEquals(3, productoSubastado.getOfertas().size());
  }

  @Test
  void elProductoNoAceptaOfertasDeSubastadoresNoRegistrados() {
    assertThrows(OfertaSubastadorException.class, () -> {
    subastador3.ofertar(productoSubastado);
    });
  }
}
