package ar.edu.unahur.obj2.observer.strategys;

import ar.edu.unahur.obj2.observer.Oferta;
import ar.edu.unahur.obj2.observer.observables.ProductoSubatado;
import ar.edu.unahur.obj2.observer.observadores.Subastador;

public class SubastadorArriesgado implements StrategySubastador {

  @Override
  public void ofertar(ProductoSubatado productoSubastado, Subastador subastador) {
    productoSubastado.agregarOferta(
      new Oferta
      (this.montoEsperado(productoSubastado), subastador
      )
    );
  }

  @Override
  public Integer montoEsperado(ProductoSubatado productoSubatado) {
    if (productoSubatado.obtenerUltimaOferta() == null) {
      return 10;
    }
    return productoSubatado.obtenerUltimaOferta().getMonto() + 10;
  }
  
}
