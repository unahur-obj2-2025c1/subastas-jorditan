package ar.edu.unahur.obj2.observer.strategys;

import ar.edu.unahur.obj2.observer.observables.ProductoSubatado;
import ar.edu.unahur.obj2.observer.observadores.Subastador;

public interface StrategySubastador {
  public void ofertar(ProductoSubatado productoSubastado, Subastador subastador);
  public Integer montoEsperado(ProductoSubatado productoSubatado);
}
