package ar.edu.unahur.obj2.observer.strategys;

import ar.edu.unahur.obj2.observer.Oferta;
import ar.edu.unahur.obj2.observer.observables.ProductoSubatado;
import ar.edu.unahur.obj2.observer.observadores.Subastador;

public abstract class Strategy implements StrategySubastador {
  
  @Override
  public void ofertar(ProductoSubatado productoSubastado, Subastador subastador) {
    if (!productoSubastado.saberSiSubastadorOferto(subastador)) {
      productoSubastado.agregarOferta(
      new Oferta (this.montoEsperado(productoSubastado), subastador));
    }
  }

  @Override
  public Integer montoEsperado(ProductoSubatado productoSubatado) {
    if (productoSubatado.getOfertas().size() == 0) {
      return 10;
    }
    return productoSubatado.obtenerUltimaOferta().getMonto() + 10;
  }
}
