package uniandes.taller2.modelo;

public class ProductoMenu {
  private String nombre;
  private int precioBase;

  public ProductoMenu(String nombre, int precioBase) {
    this.nombre = nombre;
    this.precioBase = precioBase;
  }

  public String getNombre() { return nombre; }
  public int getPrecioBase() { return precioBase; }
  public String generarTextoFactura() { return "[[FACTURA]]"; }
}
