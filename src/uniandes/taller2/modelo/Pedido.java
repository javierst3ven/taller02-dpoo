package uniandes.taller2.modelo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Pedido {
  private int numeroPedidos = 0;
  private int idPedido;
  private String nombreCliente;
  private String direccionCliente;
  private ArrayList<Producto> itemsPedido = new ArrayList<Producto>();

  /**
   * Construye un nuevo Pedido con el nombre y dirección del cliente
   * 
   * @param nombreCliente El nombre del cliente
   * @param direccionCliente La dirección del cliente
   */
  public Pedido(String nombreCliente, String direccionCliente) {
    this.nombreCliente = nombreCliente;
    this.direccionCliente = direccionCliente;
    numeroPedidos++;
    this.idPedido = numeroPedidos;
  }

  /**
   * Consulta id del pedido
   * 
   * @return idPedido
   */
  public int getIdPedido() { 
    return this.idPedido;
  }

  /**
   * Agrega un nuevo producto al arreglo
   * 
   * @param nuevoItem El nuevo producto que será agregado
   */
  public void agregarProducto(Producto nuevoItem) {
    this.numeroPedidos = numeroPedidos + 1;
    this.itemsPedido.add(nuevoItem);
  }

  /**
   * Guarda la factura del pedido
   * 
   * @param archivo El archivo en el que se va a guardar el texto de la factura
   */
  public void guardarFactura(File archivo) {
    try {
      FileWriter file = new FileWriter(archivo);
      file.write(generarTextoFactura());
      file.close();
    } catch (IOException e) {
      System.err.println("ERROR: no se ha podido crear la factura!");
    }
  }

  /**
   * Genera el precio neto del pedido
   * 
   * @return precioNetoPedido
   */
  private int getPrecioNetoPedido() {
    int precioNetoPedido = 0;
    for (Producto producto : itemsPedido) {
      precioNetoPedido += producto.getPrecio();
    }
    return precioNetoPedido;
  }

  /**
   * Genera la suma del 19% de cada uno de los productos
   * 
   * @return precioIVAPedido
   */
  private int getPrecioIVAPedido() {
    return (int) (this.getPrecioNetoPedido() * 0.19);
  }

  /**
   * Genera el precio total del pedido sumando el precio neto total y el precio del IVA
   * 
   * @return precioTotalPedido
   */
  private int getPrecioTotalPedido() {
    return this.getPrecioIVAPedido() + this.getPrecioNetoPedido();
  }

  /**
   * Genera un String con el siguiente formato de factura
   * 
   * <pre>
   * Pedido No. (n)
   * ###################
   * producto 1 :: 9999
   * producto 2 :: 9999
   * ###################
   * Total pedido: 99999
   * Total pedido (IVA): 999
   * Total Pedido (IVA+Neto): 9999
   * </pre>
   * 
   * @return textoFactura Un String con todo el formato para la factura
   */
  private String generarTextoFactura() {
    String textoFactura = "";
    textoFactura += "PEDIDO No. (" + idPedido + ")\n";
    textoFactura += "###################\n";
    for(Producto producto : itemsPedido) {
      textoFactura += producto.generarTextoFactura();
    }
    textoFactura += "###################\n";
    textoFactura += "Total pedido:" + getPrecioNetoPedido() + "\n";
    textoFactura += "Total pedido (IVA):" + getPrecioIVAPedido() + "\n";
    textoFactura += "Total pedido (IVA+Neto):" + getPrecioTotalPedido() + "\n";
    textoFactura += "###################\n";
    return textoFactura;
  }
}
