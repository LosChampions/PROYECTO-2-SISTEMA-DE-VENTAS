package controller;

import Proyecto_2_Codigo.DataSistema;
import Proyecto_2_Codigo.Utilerias;
import javafx.event.ActionEvent;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * Clase que se encargara de eliminar el producto
 * @author Edy Chay
 * @author Daniel Valdez
 *
 */
public class ControladorEliminarProducto {

	public TextField txtcodigo;
	public TextArea txtborrado;

	/**
	 * Constructor para eliminar el producto
	 * 
	 * @param actionEvent
	 */

	public void eliminar(ActionEvent actionEvent) {

		/**
		 * metodo que lo eliminar
		 */
		try {

			for (int i = 0; i < DataSistema.productos.size(); i++) {
				

				int num = Integer.parseInt(txtcodigo.getText());

				if (num == DataSistema.productos.get(i).getIdProducto()) {
					
					Object obj=DataSistema.productos.get(i);

					DataSistema.productos.remove(i);

					txtborrado.appendText("ESTO FUE ELIMINADO"+"\n");
					txtborrado.appendText(obj.toString());
				}

			}
			// cierre del metodo

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
