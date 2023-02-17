package uniandes.taller2.consola;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import uniandes.taller2.modelo.*;
import uniandes.taller2.modelo.Restaurante;

public class Aplicacion {
  static Restaurante restaurante = new Restaurante();
  static Scanner scanner = new Scanner(System.in);
  static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) {
    int option;
    do {
      mostrarMenu();
      option = scanner.nextInt();
      ejecutarOpcion(option);
    } while(option != 0);
    scanner.close();
	}

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

  public static void ejecutarOpcion(int opcionSeleccionada) {
    if(opcionSeleccionada == 0) { System.out.println("\nTerminando el programa!"); }
    else if(opcionSeleccionada == 1) { ejecutarMostrarMenu(); }
    else if(opcionSeleccionada == 2) { ejecutarIniciarNuevoPedido(); }
    else { System.out.println("Ninguna opción valida ha sido seleccionada"); }
  }

  private static void ejecutarMostrarMenu() {
    System.out.println("Mostrando el menú:");
    ArrayList<ProductoMenu> menu = restaurante.getMenuBase();
    for (ProductoMenu producto : menu) {
      System.out.println(producto.getNombre() + " :: " + producto.getPrecio());
    }
  }

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
}
