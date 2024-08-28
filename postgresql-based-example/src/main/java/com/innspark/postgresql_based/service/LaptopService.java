package com.innspark.postgresql_based.service;

import com.innspark.postgresql_based.entity.Laptop;

public interface LaptopService {

	public Laptop addLaptopDetails(Laptop laptop);
	
	public Laptop findByLaptopId(Integer laptopId);
	
	public String updateLaptop(Laptop laptop);
	
	public String deleteLaptopDetails(Integer laptopId);
}
