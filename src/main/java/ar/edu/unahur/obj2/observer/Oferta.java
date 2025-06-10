package ar.edu.unahur.obj2.observer;

public class Oferta {
  private Integer monto; 
  private String nombreOfertante;
  
  public Oferta(Integer monto, String nombreOfertante ) {
    this.monto = monto;
    this.nombreOfertante = nombreOfertante;
  }
  
  public Integer getMonto() {
    return monto;
  }
  
  public String getNombreOfertante() {
    return nombreOfertante;
  }
}
