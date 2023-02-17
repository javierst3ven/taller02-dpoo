package uniandes.taller2.modelo;

import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class Restaurante {
  private ArrayList<ProductoMenu> productosMenu = new ArrayList<ProductoMenu>();
  private ArrayList<Ingrediente> ingredientes = new ArrayList<Ingrediente>();
  
  public Restaurante () {
    File archivoIngredientes = new File("./data/ingredientes.txt");
    File archivoMenu = new File("./data/menu.txt");
    File archivoCombos = new File("./data/combos.txt");

    cargarInformacionRestaurante(
      archivoIngredientes,
      archivoMenu,
      archivoCombos
    );
  }

  public void iniciarPedido(String nombreCliente, String direccionCliente) {}

  public Pedido getPedidoEnCurso() { return new Pedido("juana", "calle19"); }
  public ArrayList<ProductoMenu> getMenuBase() { return productosMenu; }
  public ArrayList<Ingrediente> getIngredientes() { return ingredientes; }

  public void cargarInformacionRestaurante(File archivoIngredientes, File archivoMenu, File archivoCombos) {
    try {
      cargarIngredientes(archivoIngredientes);
      cargarMenu(archivoMenu);
      cargarCombos(archivoCombos);
    } catch (Exception e) {
      System.err.println("Hubo un error cargando los archivos");
    }
  }

  /*
   * Private methods
   */
  private void cargarIngredientes(File archivoIngredientes) throws FileNotFoundException {
    Scanner file = new Scanner(archivoIngredientes);
    while(file.hasNextLine()) {
      String[] data = file.nextLine().split(";");
      Ingrediente ingrediente = new Ingrediente(data[0], Integer.parseInt(data[1]));
      this.ingredientes.add(ingrediente);
    }
    file.close();
  }

  private void cargarMenu(File archivoMenu) throws FileNotFoundException {
    Scanner file = new Scanner(archivoMenu);
    while(file.hasNextLine()) {
      String[] data = file.nextLine().split(";");
      ProductoMenu producto = new ProductoMenu(data[0], Integer.parseInt(data[1]));
      this.productosMenu.add(producto);
    }
    file.close();
  }

  private void cargarCombos(File archivoCombos) throws FileNotFoundException {}
}
