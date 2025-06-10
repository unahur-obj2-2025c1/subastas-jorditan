package ar.edu.unahur.obj2.observer.observadores;

import ar.edu.unahur.obj2.observer.observables.ProductoSubatado;

public interface Observer {
  void actualizar(ProductoSubatado productoSubatado);
}
