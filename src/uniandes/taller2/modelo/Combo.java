package uniandes.taller2.modelo;

import java.util.ArrayList;

public class Combo implements Producto {
  private double descuento;
  private String nombreCombo;
  private ArrayList<ProductoMenu> itemsCombo = new ArrayList<ProductoMenu>();

  /**
   * Construye un nuevo combo con el nombre del combo y su descuento
   * 
   * @param nombreCombo Nombre que tiene el combo
   * @param descuento Descuento que tiene el combo
   */
  public Combo(String nombreCombo, double descuento) {
    this.nombreCombo = nombreCombo;
    this.descuento = descuento;
  }

  /**
   * Agrega un nuevo producto al array de productos
   * 
   * @param itemCombo Producto que será agregado
   */
  public void agregarItemACombo(ProductoMenu itemCombo) {
    this.itemsCombo.add(itemCombo);
  }

  @Override
  public int getPrecio() {
    int precio = 0;
    for(Producto producto : itemsCombo) {
      precio += producto.getPrecio();
    }
    return (int) (precio-(precio*(descuento/100)));
  }

  @Override
  public String generarTextoFactura() {
    String formato = "";
    // implementar
    return formato;
  }

  @Override
  public String getNombre() {
    return nombreCombo;
  }
}
