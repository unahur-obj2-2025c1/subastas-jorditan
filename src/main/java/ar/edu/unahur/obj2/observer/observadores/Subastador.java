package ar.edu.unahur.obj2.observer.observadores;

import ar.edu.unahur.obj2.observer.Oferta;
import ar.edu.unahur.obj2.observer.observables.ProductoSubatado;

public class Subastador implements Observer {
  private Oferta ultimaOferta;
  private String nombre;

  public void reset() {
    ultimaOferta = null;
  }

  public Subastador(String nombre) {
    this.nombre = nombre;
  }

  public String getNombre() {
    return this.nombre;
  }
  
  public Integer ofertaEsperada() {
    return this.ultimaOferta.getMonto() + 10;
  }


  public void ofertar(ProductoSubatado producto) {
    Integer ofertaEsperada;
    if (this.ultimaOferta == null) {
      ofertaEsperada = 10;
    } else {
      ofertaEsperada = this.ultimaOferta.getMonto() + 10;
    }
    producto.agregarOferta(
      new Oferta
      (ofertaEsperada, this
      )
    );
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
