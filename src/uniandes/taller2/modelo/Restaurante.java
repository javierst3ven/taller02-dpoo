package uniandes.taller2.modelo;

import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class Restaurante {
  private ArrayList<ProductoMenu> productoMenu = new ArrayList<ProductoMenu>();
  private ArrayList<Ingrediente> ingredientes = new ArrayList<Ingrediente>();
  
  public Restaurante () {}
  
  public void iniciarPedido(String nombreCliente, String direccionCliente) {}
  // public Pedido getPedidoEnCurso() {}
  public ArrayList<ProductoMenu> getMenuBase() { return productoMenu; }
  public ArrayList<Ingrediente> getIngredientes() { return ingredientes; }

  public void cargarInformacionRestaurante(File archivoIngredientes, File archivoMenu, File archivoCombos) {
    try {
      cargarIngredientes(archivoIngredientes);
      cargarMenu(archivoMenu);
      cargarCombos(archivoCombos);
    } catch (FileNotFoundException e) {
      System.err.println("ERROR: uno de los archivos no se encontro");
    }
  }

  /*
   * Private methods
   */
  private void cargarIngredientes(File archivoIngredientes) throws FileNotFoundException {
    Scanner file = new Scanner(archivoIngredientes);
    while(file.hasNextLine()) {
      String[] data = file.nextLine().split(";");
      Ingrediente ingrediente = new Ingrediente(data[0], data[1].toInt);
    }
    file.close();
  }
  private void cargarMenu(File archivoMenu) throws FileNotFoundException {}
  private void cargarCombos(File archivoCombos) throws FileNotFoundException {}
}
