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
  return (ultimaOferta != null) ? ultimaOferta.getMonto() + 10 : 10;
  }

  public void ofertar(ProductoSubatado productoSubatado) {
    strategy.ofertar(productoSubatado, this);
  }

  @Override
  public void actualizar(ProductoSubatado producto) {
  this.ultimaOferta = producto.obtenerUltimaOferta(); 
  System.out.println("[" + nombre + "] recibio nueva oferta en " + producto.getNombre() + ": " + producto.obtenerUltimaOferta().getMonto());
  }

  public Oferta getUltimaOferta() {
    return this.ultimaOferta;
  }

}
