package com.asymmetric.demo3;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.asymmetric.demo3.model.Estudiante;
import com.asymmetric.demo3.repositorios.EstudianteRepository;

//Anotamos con RestController para que Spring sepa que esto entrega REST
//en pom.xml agregamos Jasper... con esto este controlador opera JSON nativo
@RestController 
@RequestMapping("estudiante")
//@CrossOrigin(origins = "*")
@CrossOrigin
public class MiControllerE {

	//acá le decimos a Spring que debe instanciar un repositorio para Estudiantes. c
	//con este repositorio tenemos la funcionalidad de búsqueda, creación, borrado de registros en la base de datos
	@Autowired
	EstudianteRepository repo;
	
	//acá indicamos que se reciben las solicitudes tipo POST 
	@PostMapping 
	public Estudiante agregar (@RequestBody Estudiante estudiante) {

		//acá repositorio nos ayuda a guardar en la base de datos al nuevo estudiante
		return repo.save(estudiante);

	}
	
	//GetMapping atiende una solitud GET de listado de todos los estudiantes de la tabla
	//desde el browser se usa como: http://localhost:8080/listar
	//el método regresa JSON
	@GetMapping 
	public List<Estudiante> listar (){
		
		//así el repositorio nos encuentra y manda todos los registros
		return repo.findAll();
		
	}
	
	//este encuentra a un solo estudiante por ID. 
	//checa que el valor retornado es Optional. Ejemplo http://localhost:8080/estudiante/1
	@GetMapping("{id}")
	public Optional <Estudiante> getEstudiante(@PathVariable ("id") int id){
		return repo.findById(id);
	}
	
	@DeleteMapping("{id}")
	public void borrar(@PathVariable ("id") int id){
		repo.deleteById(id);
	}
	
	
	
}
