package uniandes.taller2.modelo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Pedido {
  private int numeroPedidos = 0; // llevar un global
  private int idPedido = 0;
  private String nombreCliente;
  private String direccionCliente;
  private ArrayList<Producto> itemsPedido = new ArrayList<Producto>();

  public Pedido(String nombreCliente, String direccionCliente) {
    this.nombreCliente = nombreCliente;
    this.direccionCliente = direccionCliente;
  }

  public int getIdPedido() { 
    return idPedido;
  }

  public void agregarProducto(Producto nuevoItem) {
    this.numeroPedidos = numeroPedidos + 1;
    this.idPedido = idPedido + 1;
    this.itemsPedido.add(nuevoItem);
  }

  public void guardarFactura(File archivo) {
    try {
      FileWriter file = new FileWriter(("./out/pedido"+idPedido+".txt"));
      file.write(generarTextoFactura());
      file.close();
    } catch (IOException e) {
      System.err.println("ERROR: no se ha podido crear la factura!");
    }
  }

  private int getPrecioNetoPedido() {
    int precioNetoPedido = 0;
    for (Producto producto : itemsPedido) {
      precioNetoPedido += producto.getPrecio();
    }
    return precioNetoPedido;
  }

  private int getPrecioIVAPedido() {
    int precioIVAPedido = 0;
    // implementar
    return precioIVAPedido;
  }

  private int getPrecioTotalPedido() {
    int precioTotalPedido = 0;
    // implementar
    return precioTotalPedido;
  }

  private String generarTextoFactura() {
    String textoFactura = "";
    textoFactura += "PEDIDO No. " + idPedido + "\n";
    textoFactura += "###################\n";
    for(Producto pedido : itemsPedido) {
      textoFactura += pedido.generarTextoFactura();
    }
    textoFactura += "###################\n";
    textoFactura += "Total pedido:" + getPrecioNetoPedido() + "\n";
    textoFactura += "Total pedido (IVA):" + getPrecioIVAPedido() + "\n";
    textoFactura += "Total pedido (IVA):" + getPrecioTotalPedido() + "\n";
    textoFactura += "###################\n";
    return textoFactura;
  }
}
