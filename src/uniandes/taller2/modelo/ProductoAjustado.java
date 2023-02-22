package uniandes.taller2.modelo;

import java.util.ArrayList;

public class ProductoAjustado implements Producto {
  private ProductoMenu base;
  private ArrayList<Ingrediente> agregados = new ArrayList<Ingrediente>();
  private ArrayList<Ingrediente> eliminados = new ArrayList<Ingrediente>();
  private int precioAjustado;

  /**
   * Construye un nuevo producto ajustado en base a un producto base
   * 
   * @param base Producto que será modificado
   */
  public ProductoAjustado(ProductoMenu base) {
    this.base = base;
    this.precioAjustado = base.getPrecio();
  }

  /**
   * Agrega un ingrediente al arreglo de agregados
   * 
   * @param ingrediente Ingrediente que será agregado
   */
  public void agregarIngrediente(Ingrediente ingrediente) {
    this.agregados.add(ingrediente);
    this.precioAjustado = this.precioAjustado + ingrediente.getCostoAdicional();
  }

  /**
   * Elimina un ingrediente al arreglo de eliminados
   * 
   * @param ingrediente Ingrediente que será eliminado
   */
  public void eliminarIngrediente(Ingrediente ingrediente) {
    this.eliminados.add(ingrediente);
  }

  @Override
  public String getNombre() {
    return this.base.getNombre();
  }

  @Override
  public int getPrecio() {
    return this.base.getPrecio() + this.precioAjustado;
  }

  @Override
  public String generarTextoFactura() {
    String factura = "";
    // implementar
    return factura;
  }
}
