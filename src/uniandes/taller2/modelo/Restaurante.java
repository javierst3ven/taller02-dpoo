package uniandes.taller2.modelo;

import java.util.ArrayList;
import java.io.File;

public class Restaurante {
  public Restaurante () {}
  public void iniciarPedido() {}
  // public Pedido getPedidoEnCurso() {}
  public ArrayList<ProductoMenu> getMenuBase() {}
  public ArrayList<Ingrediente> getIngredientes() {}
  public void cargarInformacionRestaurante(File archivoIngredientes, File archivoMenu, File archivoCombos) {}

  /*
   * Private methods
   */
  private void cargarIngredientes(File archivoIngredientes) {}
  private void cargarMenu(File archivoMenu) {}
  private void cargarCombos(File archivoCombos) {}
}
