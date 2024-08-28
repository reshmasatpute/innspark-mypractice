package com.innspark.postgresql_based.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.innspark.postgresql_based.entity.Laptop;
import com.innspark.postgresql_based.repository.LaptopRepository;

@Service
public class LaptopServiceImpl implements LaptopService {

	@Autowired
	private LaptopRepository laptopRepository;

	@Override
	public Laptop addLaptopDetails(Laptop laptop) {
		return laptopRepository.save(laptop);
	}

	@Override
	public Laptop findByLaptopId(Integer laptopId) {
		Laptop laptop = laptopRepository.findById(laptopId).get();
		return laptop;
	}

	@Override
	public String updateLaptop(Laptop laptop) {
		Laptop laptop2 = laptopRepository.findById(laptop.getLaptopId()).get();
		if (laptop2.getLaptopId() != 0) {
			BeanUtils.copyProperties(laptop, laptop2);
			laptopRepository.save(laptop2);
			return "UPDATE_SUCCESSFULL";
		}
		return "UPDATE_FAILURE";
	}

	@Override
	public String deleteLaptopDetails(Integer laptopId) {
		Laptop laptop = laptopRepository.findById(laptopId).get();
		if (laptop.getLaptopId() != 0) {
			laptopRepository.delete(laptop);
			return "LAPTOP_DELETED_SUCCESS";
		}
		return "LAPTOP_DELETE_FAILURE";
	}

}
