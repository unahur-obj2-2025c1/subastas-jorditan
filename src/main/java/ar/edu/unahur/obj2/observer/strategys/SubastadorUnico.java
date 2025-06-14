package ar.edu.unahur.obj2.observer.strategys;

import ar.edu.unahur.obj2.observer.Oferta;
import ar.edu.unahur.obj2.observer.observables.ProductoSubatado;
import ar.edu.unahur.obj2.observer.observadores.Subastador;

public class SubastadorUnico extends Strategy{

  @Override
  public void ofertar(ProductoSubatado productoSubastado, Subastador subastador) {
    if (!productoSubastado.saberSiSubastadorOferto(subastador)) {
      productoSubastado.agregarOferta(
      new Oferta (this.montoEsperado(productoSubastado), subastador));
    }
  }
}
