package uniandes.taller2.modelo;

import java.util.ArrayList;

public class Combo {
  private double descuento;
  private String nombreCombo;
  private ArrayList<Producto> itemsCombo = new ArrayList<Producto>();

  public Combo(String nombreCombo, double descuento) {
    this.descuento = descuento;
    this.nombreCombo = nombreCombo;
  }

  public void agregarItemACombo(Producto itemCombo) {
    this.itemsCombo.add(itemCombo);
  }

  public int getPrecio() {
    int precio = 0;
    for(Producto producto : itemsCombo) {
      precio += producto.getPrecio();
    }
    return precio;
  }

  public String generarTextoFactura() {
    String factura = "";
    // implementar
    return factura;
  }

  public String getNombre() { return nombreCombo; }
}
