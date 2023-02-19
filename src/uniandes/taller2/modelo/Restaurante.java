package uniandes.taller2.modelo;

import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

/*
 * función de pedidoEnCurso
 * implementar guardarYCerrarPedido
 */

public class Restaurante {
  private ArrayList<Combo> combos = new ArrayList<Combo>();
  private ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
  private int pedidoEnCurso = 0;
  private ArrayList<ProductoMenu> menuBase = new ArrayList<ProductoMenu>();
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

  public void iniciarPedido(String nombreCliente, String direccionCliente) {
    Pedido pedido = new Pedido(nombreCliente, direccionCliente);
    pedidos.add(pedido);
    this.pedidoEnCurso = 1;
  }

  public void cerrarYGuardarPedido() {
    // escribir en un archivo txt el pedido, sacarlo de la lista y cambiar
    // pedido en curso a 0
    this.pedidoEnCurso = 0;
  }

  public Pedido getPedidoEnCurso() {
    return this.pedidos.get(0);
  }

  public ArrayList<ProductoMenu> getMenuBase() {
    return this.menuBase;
  }

  public ArrayList<Ingrediente> getIngredientes() {
    return this.ingredientes;
  }

  public void cargarInformacionRestaurante(File archivoIngredientes, File archivoMenu, File archivoCombos) {
    try {
      cargarIngredientes(archivoIngredientes);
      cargarMenu(archivoMenu);
      cargarCombos(archivoCombos);
    } catch (FileNotFoundException e) {
      System.err.println("Hubo un error cargando los archivos");
    }
  }

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
      this.menuBase.add(producto);
    }
    file.close();
  }

  private void cargarCombos(File archivoCombos) throws FileNotFoundException {
    Scanner file = new Scanner(archivoCombos);
    while(file.hasNextLine()) {
      String[] data = file.nextLine().split(";");
      Combo combo = new Combo(data[0], Integer.parseInt(data[1].replace("%", "")));
      this.combos.add(combo);
    }
    file.close();
  }
}
