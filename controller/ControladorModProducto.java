package controller;

import Proyecto_2_Codigo.DataSistema;
import Proyecto_2_Codigo.TipoProducto;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

public class ControladorModProducto {

	public TextField txtcodigo;
	public TextField txtnombre;
	public TextField txtprecio;
	public TextField txttipo;
	public static int prueba;

	public void buscarproducto1(ActionEvent actionEvent) {

		try {

			for (int i = 0; i < DataSistema.productos.size(); i++) {

				int num = Integer.parseInt(txtcodigo.getText());
				System.out.println(i);
				if (num == DataSistema.productos.get(i).getIdProducto()) {

					txtnombre.setText(DataSistema.productos.get(i).getNombreProducto());
					txtprecio.setText(Double.toString(DataSistema.productos.get(i).getPrecio()));
					txttipo.setText(DataSistema.productos.get(i).getTipodeProducto().toString());

					prueba = i;

				}

			}

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public void modificar1(ActionEvent actionEvent) {

		DataSistema.productos.get(prueba).setNombreProducto(txtnombre.getText());
		DataSistema.productos.get(prueba).setTipodeProducto(TipoProducto.PRODUCTOVARIOS);
		DataSistema.productos.get(prueba).setPrecio(Double.parseDouble(txtprecio.getText()));

	}

}
