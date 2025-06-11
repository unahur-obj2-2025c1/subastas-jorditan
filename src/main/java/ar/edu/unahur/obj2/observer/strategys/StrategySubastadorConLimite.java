package ar.edu.unahur.obj2.observer.strategys;

import ar.edu.unahur.obj2.observer.Oferta;
import ar.edu.unahur.obj2.observer.observables.ProductoSubatado;
import ar.edu.unahur.obj2.observer.observadores.Subastador;

public class StrategySubastadorConLimite extends Strategy {
  Integer montoMaximo;

  public StrategySubastadorConLimite (Integer maximo) {
    this.montoMaximo = maximo;
  }

  @Override
  public void ofertar(ProductoSubatado productoSubastado, Subastador subastador) {
    if (this.montoEsperado(productoSubastado) < montoMaximo) {
      productoSubastado.agregarOferta(
        new Oferta
        (this.montoEsperado(productoSubastado), subastador
        )
      );
    } 
  }
}
