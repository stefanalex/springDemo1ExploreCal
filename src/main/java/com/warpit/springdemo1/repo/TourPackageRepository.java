package com.warpit.springdemo1.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;

import com.warpit.springdemo1.domain.Tour;
import com.warpit.springdemo1.domain.TourPackage;

public interface TourPackageRepository  extends JpaRepository<TourPackage, String>{
	
	Optional<TourPackage> findByName(String name);
	
	/*
	 * @RestResource(exported = false) <S extends Tour> S save(S s);
	 * 
	 * 
	 * @RestResource(exported = false) void deleteById(Integer integer);
	 * 
	 * 
	 * @RestResource(exported = false) void delete(Tour tour);
	 * 
	 * 
	 * 
	 * 
	 * @RestResource(exported = false) void deleteAll();
	 */

}
