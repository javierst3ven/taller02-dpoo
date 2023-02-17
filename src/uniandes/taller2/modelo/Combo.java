package uniandes.taller2.modelo;

public class Combo {
  private double descuento;
  private String nombreCombo;

  public Combo(String nombreCombo, double descuento) {
    this.descuento = descuento;
    this.nombreCombo = nombreCombo;
  }

  public void agregarItemACombo(Producto itemCombo) {}
  public int getPrecio() { return 12; }
  public String generarTextoFactura() { return ""; }
  public String getNombre() { return nombreCombo; }
}
