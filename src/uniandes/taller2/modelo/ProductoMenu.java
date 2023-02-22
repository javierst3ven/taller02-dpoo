package uniandes.taller2.modelo;

public class ProductoMenu implements Producto {
  private String nombre;
  private int precioBase;

  /**
   * Construye un nuevo ProductoMenu con un nombre y un precio base
   * 
   * @param nombre Nombre del producto
   * @param precioBase Precio del producto
   */
  public ProductoMenu(String nombre, int precioBase) {
    this.nombre = nombre;
    this.precioBase = precioBase;
  }

  @Override   
  public String getNombre() {
    return this.nombre;
  }
  
  @Override
  public int getPrecio() {
    return this.precioBase;
  }

  @Override
  public String generarTextoFactura() {
    return "[*] " + this.nombre + " :: $" + this.precioBase;
  }
}
