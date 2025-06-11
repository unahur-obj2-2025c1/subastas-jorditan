package ar.edu.unahur.obj2.observer.observables;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.observer.excepciones.OfertaSubastadorException;
import ar.edu.unahur.obj2.observer.observadores.Subastador;
import ar.edu.unahur.obj2.observer.strategys.StrategySubastadorConLimite;
import ar.edu.unahur.obj2.observer.strategys.SubastadorArriesgado;
import ar.edu.unahur.obj2.observer.strategys.SubastadorUnico;

class ProductoSubatadoTest {
  ProductoSubatado productoSubastado = new ProductoSubatado("Auto BMW");
  Subastador subastador1 = new Subastador("gonzager", new SubastadorArriesgado());
  Subastador subastador2 = new Subastador("martomau", new SubastadorArriesgado());
  Subastador subastador3 = new Subastador("diazdan", new SubastadorArriesgado());
  Subastador subastador4 = new Subastador("matias", new StrategySubastadorConLimite(30));
  Subastador subastador5 = new Subastador("jordan", new SubastadorUnico());

  @BeforeEach
  void setupEscenario1() {
    productoSubastado.reset();
    subastador1.reset();
    subastador2.reset();
    subastador3.reset();

    productoSubastado.agregarObservador(subastador1);
    productoSubastado.agregarObservador(subastador2);
    productoSubastado.agregarObservador(subastador4);
    productoSubastado.agregarObservador(subastador5);

    subastador2.ofertar(productoSubastado);
    subastador1.ofertar(productoSubastado);
    subastador2.ofertar(productoSubastado);
    subastador4.ofertar(productoSubastado);
    subastador5.ofertar(productoSubastado);
    subastador5.ofertar(productoSubastado);
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

  
  @Test
  void laOfertaDelSubastadorConLimiteNoSeEfectaPorSuperarSuLimiteDe30() {
    assertEquals(30, productoSubastado.obtenerUltimaOferta().getMonto());
  }

  @Test
  void laOfertaDelSubastadorJordanSoloSuma1SolaVezYaQueNoPuedeOfertarMasDe1Vez() {
    assertEquals(40, productoSubastado.obtenerUltimaOferta().getMonto());
  }
}
