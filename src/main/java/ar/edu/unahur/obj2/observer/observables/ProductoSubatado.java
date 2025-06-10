package ar.edu.unahur.obj2.observer.observables;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import ar.edu.unahur.obj2.observer.Oferta;
import ar.edu.unahur.obj2.observer.observadores.Observer;

public class ProductoSubatado implements Observable{
  private String nombre;
    private List<Oferta> ofertas = Arrays.asList();
    private Set<Observer> observadores = new HashSet<>();

    public ProductoSubatado(String nombre) {
      this.nombre = nombre;
    }

    public void agregarOferta(Oferta oferta) {
      // Validación de oferta si el ofertador es un observador
      ofertas.add(oferta);
      this.notificar();
    }

    public Oferta obtenerUltimaOferta() {
      Integer ultimoIndice = ofertas.size() - 1;
      return ofertas.get(ultimoIndice);
    }

    @Override
    public void agregarObservador(Observer observador) {
      observadores.add(observador);
    }

    @Override
    public void quitarObservador(Observer observador) {
      observadores.remove(observador);
    }

    @Override
    public void notificar() {
      observadores.stream().forEach(o -> o.actualizar(this));
    }

    public String getNombre() {
      return this.nombre;
    }
}
