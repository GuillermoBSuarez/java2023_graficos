package view.adaptars;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Empleado;
import service.EmpleadosService;

public class TablaEmpleadosModel extends AbstractTableModel {

	List<Empleado> empleados;
	
	// CONSTRUCTOR
	public TablaEmpleadosModel() {
		empleados = new EmpleadosService().empleados();
	}

	// Ojo, debe extender DefaultTableModel, que si por error eliges otro, al hacer clic derecho > Source > Overwrite
	// en el editor, aparecen otros métodos. 4 de estos están en DefaultTableModel, y el 5º (getColumnClass) en AbstractTableModel.
	// Estas son las funciones que hay que sobreescribir obligatoriamente para definir la tabla.
	
	// Peeeeero DefaultTableModel tiene un error de programación por el que crea la lista... pero la pierde,
	// con lo cual al ejecutar da un NullPointerException, así que la cambiarmos por Abstract.
	
	@Override
	public int getRowCount() {
		return empleados.size();
	}

	@Override
	public int getColumnCount() {
		return 4;
	}

	@Override
	public String getColumnName(int column) {
		/* SWITCH EN EXPRESIONES: SÓLO VÁLIDO EN JAVA 17
		return switch (column) {
			case 0 -> "Nombre";
			case 1 -> "E-mail";
			case 2 -> "Salario";
			case 3 -> "Departamento";
			default -> "Indeterminado";
		};	*/
		
		switch (column) {
			case 0: return "Nombre";
			case 1: return "E-mail";
			case 2: return "Salario";
			case 3: return "Departamento";
			default: return "Indeterminado";
		}
	}

	@Override
	public Object getValueAt(int row, int column) {
		switch (column) {
			case 0: return empleados.get(row).getNombre();
			case 1: return empleados.get(row).getEmail();
			case 2: return empleados.get(row).getSalario();
			case 3: return empleados.get(row).getDepartamento();
			default: return null;
		}
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
			// La interrogación significa que puede devolver una class de cualquier tipo Java
		switch (columnIndex) {
			case 0: return String.class;
			case 1: return String.class;
			case 2: return Double.class;
			case 3: return String.class;
			default: return null;
		}
	}
}
