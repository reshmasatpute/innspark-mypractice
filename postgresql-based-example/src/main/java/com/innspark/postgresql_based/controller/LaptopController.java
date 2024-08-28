package com.innspark.postgresql_based.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.innspark.postgresql_based.entity.Laptop;
import com.innspark.postgresql_based.service.LaptopService;

@RestController
@RequestMapping("/laptop")
public class LaptopController {

	@Autowired
	private LaptopService laptopService;

	@PostMapping("/addLaptopDetails")
	public Laptop addLaptopDetails(@RequestBody Laptop laptop) {
		return laptopService.addLaptopDetails(laptop);
	}

	@GetMapping("/get-laptop/{id}")
	public Laptop getLaptop(@PathVariable Integer id) {
		return laptopService.findByLaptopId(id);
	}

	@PutMapping("/update")
	public String updateLaptop(@RequestBody Laptop laptop) {
		return laptopService.updateLaptop(laptop);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteLaptop(@PathVariable Integer id) {
		String deleteLaptopDetails = laptopService.deleteLaptopDetails(id);
		return deleteLaptopDetails;
		
	}
	
}
