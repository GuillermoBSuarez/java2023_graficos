package service;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.google.gson.Gson;

import model.Empleado;

public class EmpleadosService {

	private Stream<Empleado> getEmpleados(){
		String ruta="c:\\temp\\empleados.json";
		Gson gson=new Gson();
		try( FileReader fr = new FileReader(ruta); ) {
			Empleado[] empleados = gson.fromJson(fr, Empleado[].class);
			return Arrays.stream(empleados);
		} catch(IOException ex) {
			ex.printStackTrace();
			return Stream.empty();
		}
	}
	
	public List<Empleado> empleados(){
		return getEmpleados()									// Stream<Empleado>
				.collect(Collectors.toList());					// List<Empleado>
	}
	
	public List<Empleado> empleadosDepartamento(String dpto){
		return getEmpleados()									// Stream<Empleado>
				.filter( e -> e.getDepartamento().equals(dpto)) // Stream<Empleado>
				.collect(Collectors.toList());					// List<Empleado>
	}
	
	public List<String> departamentos(){
		return getEmpleados()									// Stream<Empleado>
				.map( e -> e.getDepartamento() )				// Stream<String>
				.distinct()										// Stream<String>
				.toList();										// List<String>
	}
}	