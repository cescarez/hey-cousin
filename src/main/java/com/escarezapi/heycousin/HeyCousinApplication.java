package com.escarezapi.heycousin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@RestController
public class HeyCousinApplication {

	public static void main(String[] args) {
		SpringApplication.run(HeyCousinApplication.class, args);
	}

	@GetMapping("/hello")
	String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("Hello %s!", name);
	}

	@GetMapping("/cousins")
	List<Cousin> getAllCousins() {
	    List<> allCousins; //call database and return all names -- implement generics here
		return allCousins;
	}

	@GetMapping("/cousin/{id}")
	Cousin getCousin(@PathVariable String id) {
		Cousin found; //call database and search for cousin by id, assigning to local
//        .orElseThrow(() -> new CousinNotFoundException(id));
		return found ? found : "Cousin not found."; //return results of fuzzy search
	}

	@PostMapping("/cousin/{id}")
	Cousin updateCousin(@RequestBody Cousin newCousin, @PathVariable String id) {
	    //create new cousin
		Cousin newest; //return latest Cousin in database
		return newest;
	}

	@PutMapping("/cousin/{id}")
	Cousin updateCousin(@RequestBody Cousin updatedCousin, @PathVariable String id) {
		Cousin updated; // call database and
		return updated;
	}

	@DeleteMapping("/cousin/{id}")
	void deleteCousin(@PathVariable String id) {
		//delete by id from database
	}
}
