package ar.edu.unahur.obj2.observer.strategys;

import ar.edu.unahur.obj2.observer.Oferta;
import ar.edu.unahur.obj2.observer.excepciones.OfertaSubastadorException;
import ar.edu.unahur.obj2.observer.observables.ProductoSubatado;
import ar.edu.unahur.obj2.observer.observadores.Subastador;

public class StrategySubastadorConLimite  implements StrategySubastador{
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

  @Override
  public Integer montoEsperado(ProductoSubatado productoSubatado) {
    if (productoSubatado.getOfertas().size() == 0) {
      return 10;
    }
    return productoSubatado.obtenerUltimaOferta().getMonto() + 10;
  }
  
}
