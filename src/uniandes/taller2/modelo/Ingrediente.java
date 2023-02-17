package uniandes.taller2.modelo;

public class Ingrediente {
  private String nombre;
  private int costoAdicional;

  public Ingrediente(String nombre, int costoAdicional) {
    this.nombre = nombre;
    this.costoAdicional = costoAdicional;
  }

  public String getNombre() { return nombre; }
  public int getCostoAdicional() { return costoAdicional; }
}
