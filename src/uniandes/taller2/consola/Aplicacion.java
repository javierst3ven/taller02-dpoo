package uniandes.taller2.consola;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import uniandes.taller2.modelo.Restaurante;
import uniandes.taller2.modelo.ProductoMenu;

public class Aplicacion {
  private static Restaurante restaurante = new Restaurante();
  private static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

	/**
	 * Punto de entrada de la aplicación
	 */
	public static void main(String[] args) {
    int option = 1;
    while(option!=0) {
      try {
        mostrarMenu();
        option = Integer.parseInt(bf.readLine());
        ejecutarOpcion(option);
      } catch (IOException e) {
        System.err.println("ERROR: no se ha podido leer la linea");
      }
    }
	}

  /**
   * Imprime el menu con las opciones disponibles
   */
  public static void mostrarMenu() {
    System.out.println("\n******************************************************");
    System.out.println("====================    MENU   =======================");
    System.out.println("******************************************************");
    System.out.println("==================    OPCIONES   =====================");
    System.out.println("******************************************************");
    System.out.println("[1] Mostrar el menú");
    System.out.println("[2] Iniciar un nuevo pedido");
    System.out.println("[3] Agregar un elemento a un pedido");
    System.out.println("[4] Cerrar un pedido y guardar la factura");
    System.out.println("[5] Consultar la información de un pedido dado su id");
    System.out.println("******************************************************");
    System.out.print("\n$> ");
  }

  /**
   * Ejecuta una opción
   * 
   * @param opcionSeleccionada Opcion que será ejecutada
   */
  public static void ejecutarOpcion(int opcionSeleccionada) {
    if(opcionSeleccionada == 0) { System.out.println("\nTerminando el programa!"); }
    else if(opcionSeleccionada == 1) { ejecutarMostrarMenu(); }
    else if(opcionSeleccionada == 2) { ejecutarIniciarNuevoPedido(); }
    else if(opcionSeleccionada == 3) { ejecutarAgregarElementoPedido(); }
    else if(opcionSeleccionada == 4) { ejecutarCerrarPedidoYGuardarFactura(); }
    else if(opcionSeleccionada == 5) { ejecutarConsultarInformacionPedido(); }
    else { System.out.println("Ninguna opción valida ha sido seleccionada"); }
  }

  /**
   * Muestra el menu disponible
   */
  private static void ejecutarMostrarMenu() {
    System.out.println("################################");
    System.out.println("MENU:");
    ArrayList<ProductoMenu> menu = restaurante.getMenuBase();
    System.out.println("################################");
    for (ProductoMenu producto : menu) {
      System.out.println(producto.generarTextoFactura());
    }
    System.out.println("################################");
  }

  /**
   * Inicia un nuevo pedido
   */
  private static void ejecutarIniciarNuevoPedido() {
    try {
      System.out.println("Ingrese el nombre del cliente: ");
      String nombreCliente = bf.readLine();
      System.out.println("Ingrese la dirección del cliente: ");
      String direccionCliente = bf.readLine();
      restaurante.iniciarPedido(nombreCliente, direccionCliente);
    } catch (IOException exception) {
      System.err.println("ERROR: no se ha podido crear el pedido");
    }
  }

  /**
   * Agrega un nuevo elemento al pedido
   */
  private static void ejecutarAgregarElementoPedido() {

  }

  /**
   * Cierra y guarda un pedido en una factura
   */
  private static void ejecutarCerrarPedidoYGuardarFactura() {

  }

  /**
   * Consulta la información del pedido
   */
  private static void ejecutarConsultarInformacionPedido() {

  }
}
