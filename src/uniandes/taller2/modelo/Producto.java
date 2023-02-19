package uniandes.taller2.modelo;

public interface Producto {
  public abstract int getPrecio();
  public abstract String getNombre();
  public abstract String generarTextoFactura();
}
