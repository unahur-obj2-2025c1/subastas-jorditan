package ar.edu.unahur.obj2.observer.observables;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import ar.edu.unahur.obj2.observer.Oferta;
import ar.edu.unahur.obj2.observer.excepciones.OfertaSubastadorException;
import ar.edu.unahur.obj2.observer.observadores.Observer;
import ar.edu.unahur.obj2.observer.observadores.Subastador;

public class ProductoSubatado implements Observable{
    private String nombre;
    List<Oferta> ofertas = new ArrayList<>();
    private Set<Observer> observadores = new HashSet<>();

    public ProductoSubatado(String nombre) {
      this.nombre = nombre;
    }

    public List<Oferta> getOfertas () {
      return this.ofertas;
    }

    public void agregarOferta(Oferta oferta) {
      if (observadores.contains(oferta.getSubastador())) {
        ofertas.add(oferta);
        this.notificar();
      } else {
        throw new OfertaSubastadorException("El subastador no participa en la subasta");
      }
    }

    public Boolean saberSiSubastadorOferto(Subastador subastador) {
    return ofertas.stream().anyMatch(o -> o.getSubastador() == subastador);
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

    public void reset() {
      ofertas.clear();
      observadores.clear();
    }
}
