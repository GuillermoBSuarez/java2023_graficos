package view.adaptars;

import java.util.List;

import javax.swing.DefaultComboBoxModel;

import service.EmpleadosService;

public class ComboDepartamentosModel extends DefaultComboBoxModel {

	List<String> departamentos;
	
	// CONSTRUCTOR
	public ComboDepartamentosModel() {
		departamentos = new EmpleadosService().departamentos();
	}

	@Override
	public int getSize() {
		return departamentos.size();
	}

	@Override
	public Object getElementAt(int index) {
		return departamentos.get(index);
	}

	
}