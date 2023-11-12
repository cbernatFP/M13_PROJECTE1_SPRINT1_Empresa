package cbm.itic.m12.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import cbm.itic.m12.exception.EmpresaNotFoundException;
import cbm.itic.m12.model.Empresa;
import cbm.itic.m12.repository.EmpresaRepository;

@RestController
@RequestMapping("/api")
public class EmpresaController {
	@Autowired
	private EmpresaRepository empresaRepository;

	@GetMapping("/empresa")
	public Iterable<Empresa> buscaTots() {
		System.out.println("222222222222");
		return empresaRepository.findAll();
	}

//  buscaPerId v1	
//  ----------------	
//	@GetMapping("/empresa/{id}")
//	public Optional<Empresa> buscaPerId(@PathVariable long id) {
//		System.out.println("33333333333");
//    	return empresaRepository.findById(id);
//	}

//  buscaPerId v2	
//  ----------------	
// PQ DONA ERROR AQUEST CODI?????	
//	@GetMapping("/empresa/{id}")
//	public Empresa buscaPerId(@PathVariable long id) {
//		System.out.println("33333333333");
//    	return empresaRepository.findById(id);
//	}

	// https://docs.spring.io/spring-data/commons/docs/current/api/org/springframework/data/repository/CrudRepository.html#findById(ID)
	// https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/Optional.html

//  buscaPerId v3	
//  ----------------	
//	@GetMapping("/empresa/{id}")
//	Empresa buscaPerId(@PathVariable Long id) {
//		return empresaRepository.findById(id).orElseThrow();
//	}

//  buscaPerId v4	
//  ----------------	
	@GetMapping("/empresa/{id}")
	Empresa buscaPerId(@PathVariable Long id) {
		 return empresaRepository.findById(id)
		 	      .orElseThrow(() -> new EmpresaNotFoundException());		
	}
	
	// VEIEU LA DIFERÈNCIA DE LA RESPOSTA entre la v3 o v4 quan demanem una empresa que no existeix
	// GET http://localhost:8080/api/empresa/44
	// Mireu el message del ResponseBody
	

	@PostMapping("/empresa")
	@ResponseStatus(HttpStatus.CREATED)
	public Empresa afegeix(@RequestBody Empresa empresa) {
		System.out.println("44444444444444444");
		// POSEM UN BEAKPOINT !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		Empresa empresa1 = empresaRepository.save(empresa);
		return empresa1;
	}

	@DeleteMapping("/empresa/{id}")
	public void esborra(@PathVariable long id) {
		empresaRepository.deleteById(id);
	}

}
