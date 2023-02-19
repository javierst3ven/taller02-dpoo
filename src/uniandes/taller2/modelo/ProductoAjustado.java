package uniandes.taller2.modelo;

import java.util.ArrayList;

public class ProductoAjustado implements Producto {
  private ProductoMenu base;
  private ArrayList<Ingrediente> agregados = new ArrayList<Ingrediente>();
  private ArrayList<Ingrediente> eliminados = new ArrayList<Ingrediente>();

  public ProductoAjustado(ProductoMenu base) {
    // implementar
  } 

  public String getNombre() {
    // implementar
    return "";
  }

  public int getPrecio() {
    // implementar
    return 12;
  }

  public String generarTextoFactura() {
    String factura = "";
    for(int i=0; i<agregados.size(); i++) {
      if(i!=(agregados.size()-1)) { factura += agregados.get(i) + ", "; }
      else { factura += " y " + agregados.get(i); }
    }
    return factura;
  }
}
