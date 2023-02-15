package uniandes.taller2.consola;
import java.util.Scanner;
import uniandes.taller2.modelo.Restaurante;

public class Aplicacion {
	public static void main(String[] args) {
    Restaurante restaurante = new Restaurante();
		Scanner scanner = new Scanner(System.in);
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
    else if(opcionSeleccionada == 1) {}
  }
}
