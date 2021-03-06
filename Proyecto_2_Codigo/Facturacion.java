package Proyecto_2_Codigo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Esta clase llevara el control de las facturas tanto para clientes
 * individuales como para empresa
 * 
 * @author Edy Chay
 * @author Daniel Valdez
 *
 */
public class Facturacion extends OrdenDeVenta {

	public double getTotalDeFacturacion() {
		return totalDeFacturacion;
	}

	public void setTotalDeFacturacion(double totalDeFacturacion) {
		this.totalDeFacturacion = totalDeFacturacion;
	}

	public int getNumeroDeFactura() {
		return numeroDeFactura;
	}

	public void setNumeroDeFactura(int numeroDeFactura) {
		this.numeroDeFactura = numeroDeFactura;
	}

	private List<ItemOrden> colecItem;
	private double totalDeFacturacion;
	private int numeroDeFactura;
	private static int sigIdFactura = 70000;
	private boolean liberado = true;
	private String nombreCliente=getClassCliente().getNombreCliente();

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public static int siguienteIdF() {
		return sigIdFactura++;
	}

	public Facturacion(Date fechaorden, Cliente cliente) {
		super(fechaorden, cliente);
		colecItem = new ArrayList();
		numeroDeFactura = siguienteIdF();
	}

	/**
	 * constructor para la clase factura
	 * 
	 * @param i
	 */

	public void agregarItem(ItemOrden i) {
		if (liberado == true) {
			if (verificaitem(i) == true) {

				colecItem.add(i);
				rebajarInventario(i);

			}
		} else {

			/**
			 * Agregara el item para saber si se cumple el metodo
			 */

			System.out.println(
					"NO SE PUEDE AGREGAR ESTE ITEM PORQUE SOBRE PASA EL VALOR DEL STOCK ACTUAL, el codigo es --> "
							+ i.getProducto().getIdProducto());
		}

	}

	public void cerrarfactura() {
		liberado = false;
		getTotalOrden();
	}

	public boolean verificaitem(ItemOrden io) {
		boolean veri = false;

		for (int j = 0; j < DataSistema.productos.size(); j++) {

			if (DataSistema.productos.get(j).getIdProducto() == io.getProducto().getIdProducto()) {

				if (DataSistema.productos.get(j).getCantidadInventario() >= io.getCantidad()) {

					System.out.println(
							"--------------------------" + DataSistema.productos.get(j).getCantidadInventario());
					System.out.println("--------------------------" + io.getCantidad());
					veri = true;
				}

			}

		}

		/**
		 * verificaitem, verificara si existe el objeto
		 */

		return veri;

	}

	public void rebajarInventario(ItemOrden io) {

		int rebajar = 0;

		for (int i = 0; i < DataSistema.productos.size(); i++) {

			if (DataSistema.productos.get(i).getIdProducto() == io.getProducto().getIdProducto()) {

				rebajar = DataSistema.productos.get(i).getCantidadInventario() - io.getCantidad();
				DataSistema.productos.get(i).setCantidadInventario(rebajar);

			}

		}
	}

	/**
	 * realizara el calculo de la rebaja al inventario
	 */

	@Override
	public Cliente getClassCliente() {
		return cliente;
	}

	public double getTotalOrden() {

		Double descuento;

		Double descuentototal;

		totalDeFacturacion = 0;
		for (ItemOrden itemOrden : colecItem) {
			totalDeFacturacion = totalDeFacturacion + itemOrden.getTotalItem();
		}

		String nombre = Utilerias.getNombreClase(cliente.getClass());
		if (nombre.equals("Cliente_Empresa")) {

			descuento = (double) cliente.getDescuentoEmpresaPadre() / 100;
			descuentototal = descuento * totalDeFacturacion;
		} else {
			descuentototal = 0.00;
		}

		return totalDeFacturacion = totalDeFacturacion - descuentototal;

		/**
		 * regrega el total de factura
		 */

	}

	@Override
	public String toString() {

		for (int i = 0; i < DataFacturas.factura.size(); i++) {

			DataFacturas.factura.get(i).getTotalOrden();

		}

		String tmp = "NUMERO DE FACTURA= " + numeroDeFactura + "\n";
		tmp = tmp + "Cliente=" + getCliente().toString() + "\n";

		for (ItemOrden itemOrden : colecItem) {
			tmp = tmp + itemOrden.toString() + ", Subtotal de linea es=" + itemOrden.getTotalItem() + "\n";
		}

		tmp = tmp + "total de factura es =" + totalDeFacturacion;
		return tmp;
	}

	/**
	 * metodo publico para devolver el numero de factura
	 */

	public int getNumerodefactura() {
		return numeroDeFactura;
	}

	public String verCliente() {
		return getCliente().getNombreCliente();
	}
}
