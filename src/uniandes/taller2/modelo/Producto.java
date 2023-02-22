package uniandes.taller2.modelo;

public interface Producto {
  /**
   * @return El precio del producto
   */
  public abstract int getPrecio();

  /**
   * @return El nombre del producto
   */
  public abstract String getNombre();

  /**
   * @return Genera un texto para la factura
   */
  public abstract String generarTextoFactura();
}
