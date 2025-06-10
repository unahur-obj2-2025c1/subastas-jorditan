package ar.edu.unahur.obj2.observer;

import ar.edu.unahur.obj2.observer.observadores.Subastador;

public class Oferta {
  private Integer monto; 
  private Subastador subastador;
  
  public Oferta(Integer monto, Subastador subastador ) {
    this.monto = monto;
    this.subastador = subastador;
  }
  
  public Integer getMonto() {
    return monto;
  }
  
  public Subastador getSubastador() {
    return subastador;
  }
}
