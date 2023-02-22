package uniandes.taller2.modelo;

import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class Restaurante {
  private ArrayList<Combo> combos = new ArrayList<Combo>();
  private ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
  private Pedido pedidoEnCurso;
  private ArrayList<ProductoMenu> menuBase = new ArrayList<ProductoMenu>();
  private ArrayList<Ingrediente> ingredientes = new ArrayList<Ingrediente>();

  /**
   * Construye un nuevo Restaurante cargando la información de los
   * archivos de texto de ingredientes, menu y combos
   */
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

  /**
   * Inicia un nuevo pedido con el nombre del cliente y su dirección
   * 
   * @param nombreCliente Nombre del cliente
   * @param direccionCliente Dirección del cliente
   */
  public void iniciarPedido(String nombreCliente, String direccionCliente) {
    this.pedidoEnCurso = new Pedido(nombreCliente, direccionCliente);
  }

  /**
   * Cierra y guarda el pedido en un archivo .txt en la carpeta /out/pedido{id}.txt
   */
  public void cerrarYGuardarPedido() {
    File archivoAGuardar = new File("/out/pedido" + pedidoEnCurso.getIdPedido()+".txt");
    pedidoEnCurso.guardarFactura(archivoAGuardar);
    pedidos.add(pedidoEnCurso);
    pedidoEnCurso = null;
  }

  /**
   * Retorna el pedido que esta en curso
   * 
   * @return El pedido que esta en el indice 0 (el que esta en curso)
   */
  public Pedido getPedidoEnCurso() {
    return this.pedidoEnCurso;
  }

  public Pedido getPedidoPorID(int id) {
    for(Pedido pedido : pedidos) {
      if(pedido.getIdPedido() == id) return pedido;
    }
    return null;
  }

  /**
   * Retorna el arreglo con el menu base cargado del archivo
   * 
   * @return El arreglo con el menu
   */
  public ArrayList<ProductoMenu> getMenuBase() {
    return this.menuBase;
  }

  /**
   * Retorna el arreglo con todos los ingredientes cargados del archivo
   * 
   * @return El arreglo con los ingredientes
   */
  public ArrayList<Ingrediente> getIngredientes() {
    return this.ingredientes;
  }

  /**
   * Agrega los combos, ingredientes y el menu de la carpeta /data/*.txt
   * en un arreglo
   * 
   * @param archivoIngredientes El archivo que contiene los ingredientes
   * @param archivoMenu El archivo que contiene el menu
   * @param archivoCombos El archivo que contiene los combos
   */
  public void cargarInformacionRestaurante(File archivoIngredientes, File archivoMenu, File archivoCombos) {
    try {
      cargarIngredientes(archivoIngredientes);
      cargarMenu(archivoMenu);
      cargarCombos(archivoCombos);
    } catch (FileNotFoundException e) {
      System.err.println("Hubo un error cargando los archivos");
    }
  }

  /**
   * Agrega los ingredientes que se encuentran en el archivo /data/ingredientes.txt
   * a un arreglo de ingredientes
   * 
   * @param archivoIngredientes El archivo que contiene los ingredientes
   * @throws FileNotFoundException El archivo no se encuentra en la carpeta
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

  /**
   * Agrega los productos que se encuentran en el archivo /data/menu.txt
   * a un arreglo de productos
   * 
   * @param archivoMenu El archivo que contiene los productos del menu
   * @throws FileNotFoundException El archivo no se encuentra en la carpeta
   */
  private void cargarMenu(File archivoMenu) throws FileNotFoundException {
    Scanner file = new Scanner(archivoMenu);
    while(file.hasNextLine()) {
      String[] data = file.nextLine().split(";");
      ProductoMenu producto = new ProductoMenu(data[0], Integer.parseInt(data[1]));
      this.menuBase.add(producto);
    }
    file.close();
  }

  /**
   * Agrega los combos que se encuentran en el archivo /data/combos.txt
   * a un arreglo de productos
   * 
   * @param archivoCombos El archivo que contiene los combos
   * @throws FileNotFoundException El archivo no se encuentra en la carpeta
   */
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
