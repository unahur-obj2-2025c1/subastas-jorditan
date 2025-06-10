package ar.edu.unahur.obj2.observer.observadores;

import ar.edu.unahur.obj2.observer.Oferta;
import ar.edu.unahur.obj2.observer.observables.ProductoSubatado;

public class Subastador implements Observer {
  private String nombre;

  public Subastador(String nombre) {
    this.nombre = nombre;
  }

  public String getNombre() {
    return this.nombre;
  }
  
  public Integer ofertaEsperada(ProductoSubatado producto) {
    return producto.obtenerUltimaOferta().getMonto() + 10;
  }

  public void ofertar(ProductoSubatado producto, Integer monto) {
    producto.agregarOferta(
      new Oferta
      (this.ofertaEsperada(producto), nombre
      )
    );
  }

  @Override
  public void actualizar(ProductoSubatado productoSubatado) {
    System.out.println("Se ha realizado una oferta sobre el producto " + productoSubatado.getNombre() + "de " + productoSubatado.obtenerUltimaOferta() + "pesos");
  }
}
