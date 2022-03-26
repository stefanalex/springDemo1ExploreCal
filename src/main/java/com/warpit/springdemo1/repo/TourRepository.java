package com.warpit.springdemo1.repo;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.warpit.springdemo1.domain.Tour;

public interface TourRepository  extends JpaRepository<Tour, Integer> {
	
	Page<Tour> findByTourPackageCode(@Param("code") String code,Pageable pageable);

}
