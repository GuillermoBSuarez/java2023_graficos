package view.adapters;

import java.util.List;

import javax.swing.DefaultListModel;

import model.Pedido;
import service.PedidosService;

public class ListaPedidosModel extends DefaultListModel<Pedido> {
									   // Implemente ListModel
	List<Pedido> pedidos;
	
	public ListaPedidosModel() {				// Hereda ListModel
		pedidos = new PedidosService().todos();
	}
	
	@Override
	public int getSize() {
		return pedidos.size();					// Tamaño que tendrá la lista.
	}

	@Override
	public Pedido getElementAt(int index) {
		return pedidos.get(index);				// En la posición (index) de la lista de la pantalla
	}											// tendrá que poner lo que haya en esa posición de pedidos.
}