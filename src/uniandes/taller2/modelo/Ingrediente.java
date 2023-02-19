package uniandes.taller2.modelo;

public class Ingrediente {
  private String nombre;
  private int costoAdicional;

  /**
   * Construye un nuevo ingrediente con el nombre y el costo adicional
   * 
   * @param nombre Nombre del ingrediente
   * @param costoAdicional Costo adicional que tiene el ingrediente
   */
  public Ingrediente(String nombre, int costoAdicional) {
    this.nombre = nombre;
    this.costoAdicional = costoAdicional;
  }

  /**
   * Retorna el nombre del ingrediente
   * 
   * @return nombre
   */
  public String getNombre() {
    return this.nombre;
  }

  /**
   * Retorna el costo adicional del ingrediente
   * 
   * @return costoAdicional
   */
  public int getCostoAdicional() {
    return costoAdicional;
  }
}
