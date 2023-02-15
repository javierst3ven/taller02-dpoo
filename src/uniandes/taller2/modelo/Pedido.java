package uniandes.taller2.modelo;

import java.io.File;

public class Pedido {
  // attributes
  private int numeroPedidos = 0;
  private int idPedido = 0;
  private String nombreCliente;
  private String direccionCliente;

  // methods
  public Pedido(String nombreCliente, String direccionCliente) {
    this.nombreCliente = nombreCliente;
    this.direccionCliente = direccionCliente;
  }

  public int getIdPedido() { return idPedido; }
  public void agregarPedido(ProductoMenu nuevoItem) {

  }
  public void guardarFactura(File archivo) {}

  private int getPrecioNetoPedido() { return 1; }
  private int getPrecioTotalPedido() { return 1; }
  private int getPrecioIVAPedido() { return 1; }
  private String generarTextoFactura() { return ""; }

}
