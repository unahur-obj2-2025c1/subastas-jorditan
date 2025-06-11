package ar.edu.unahur.obj2.observer.observadores;

import ar.edu.unahur.obj2.observer.Oferta;
import ar.edu.unahur.obj2.observer.observables.ProductoSubatado;
import ar.edu.unahur.obj2.observer.strategys.StrategySubastador;

public class Subastador implements Observer {
  private Oferta ultimaOferta;
  private String nombre;
  private StrategySubastador strategy;
  
  public Subastador(String nombre, StrategySubastador strategy) {
    this.nombre = nombre;
    this.strategy = strategy;
  }

  public StrategySubastador getStrategy() {
    return strategy;
  }

  public void setStrategy(StrategySubastador strategy) {
    this.strategy = strategy;
  }

  public void reset() {
    ultimaOferta = null;
  }


  public String getNombre() {
    return this.nombre;
  }
  
  public Integer ofertaEsperada() {
    return this.ultimaOferta.getMonto() + 10;
  }


  // public void ofertar(ProductoSubatado producto) {
  //   Integer ofertaEsperada;
  //   if (this.ultimaOferta == null) {
  //     ofertaEsperada = 10;
  //   } else {
  //     ofertaEsperada = this.ultimaOferta.getMonto() + 10;
  //   }
  //   producto.agregarOferta(
  //     new Oferta
  //     (ofertaEsperada, this
  //     )
  //   );
  // }

  public void ofertar(ProductoSubatado productoSubatado) {
    strategy.ofertar(productoSubatado, this);
  }

  @Override
  public void actualizar(ProductoSubatado productoSubatado) {
    System.out.println("Se ha realizado una oferta sobre el producto " + productoSubatado.getNombre() + "de " + productoSubatado.obtenerUltimaOferta() + "pesos");
    this.ultimaOferta = productoSubatado.obtenerUltimaOferta();
  }

  public Oferta getUltimaOferta() {
    return this.ultimaOferta;
  }

}
