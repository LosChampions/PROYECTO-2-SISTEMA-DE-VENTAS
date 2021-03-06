package Proyecto_2_Codigo;

import java.util.ArrayList;
import java.util.Date;

/**
 * Esta clase sera utilizada para guardar un catalogo de cliente, producto y orden de compra.
 * @author Edy Chay
 * @author Daniel Valdez
 *
 */

public class DataSistema {



	public static ArrayList<Cliente> clientes = new ArrayList<Cliente>(8) {
		{
			add(new Cliente_Individual("Edy", "Chay", "Lote 43", "208558775"));
			add(new Cliente_Individual("Daniel", "Valdez", "Lote 41", "20875815"));
			add(new Cliente_Individual("Juan", "Ramirez", "Secto 1", "205775"));
			add(new Cliente_Individual("Andrea Marielos", "Sandoval Colindres", "Col. los cipreces", "208558633"));
			add(new Cliente_Empresa("Producto del Aire", "S.A.", " Av. Petapa", "Alejandro Mango", 30));
			add(new Cliente_Empresa("Campello", "S.A.", " Av. Roosevelt", "Sandra Trup", 25));
			add(new Cliente_Empresa("Respuesto Chay", "S.A.", " Av. Centroamerica", "Edinso Chaykoskiv", 35));
			add(new Cliente_Empresa("CarroWahsi", "S.A.", " Av. Villa Linda", "Tito Felix", 30));

		}
	};

	/**
	 *  Constructor para un cliente individual
	 */


	public static ArrayList<Producto> productos = new ArrayList<Producto>(8) {
		{

			add(new Producto("Bujia Iridium", TipoProducto.BUJIAS, 10, 23.50));
			add(new Producto("Bomba de Gasolina", TipoProducto.BOMBAS_DE_GASOLINA, 10, 85.50));
			add(new Producto("Punta de cremallera", TipoProducto.DIRECCION, 50, 500.00));
			add(new Producto("Bocina para moto", TipoProducto.BOCINAS_DE_MOTO, 70, 101.50));
			add(new Producto("Disco de Freno", TipoProducto.FRENOS_AUTOMOVILES, 15, 400.00));
			add(new Producto("Rotula", TipoProducto.DIRECCION, 115, 175.75));
			add(new Producto("Buje", TipoProducto.BUJES, 12, 12.50));
			add(new Producto("Fullset ", TipoProducto.MOTORES, 85, 300.58));

		}
	};

	/**
	 *  Constructor para un producto
	 */

	public static ArrayList<ItemOrden> item = new ArrayList<ItemOrden>(8) {
		{
			add(new ItemOrden(1, 5, DataSistema.productos.get(0)));
			add(new ItemOrden(1, 7, DataSistema.productos.get(1)));
			add(new ItemOrden(1, 9, DataSistema.productos.get(2)));
			add(new ItemOrden(1, 3, DataSistema.productos.get(3)));
			add(new ItemOrden(1, 2, DataSistema.productos.get(4)));
			add(new ItemOrden(1, 15, DataSistema.productos.get(5)));
			add(new ItemOrden(1, 300, DataSistema.productos.get(6)));
			add(new ItemOrden(1, 1, DataSistema.productos.get(0)));

		}
	};
	
	

	
	/**
	 *  Constructor para una orden de compra
	 */


	

	public static ArrayList<Cliente> getClientes() {
		return clientes;
	}

}
