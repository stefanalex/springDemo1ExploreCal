package com.warpit.springdemo1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.warpit.springdemo1.domain.Difficulty;
import com.warpit.springdemo1.domain.Region;
import com.warpit.springdemo1.domain.Tour;
import com.warpit.springdemo1.domain.TourPackage;
import com.warpit.springdemo1.repo.TourPackageRepository;
import com.warpit.springdemo1.repo.TourRepository;

@Service
public class TourService {

	@Autowired
	private TourRepository tourRepository;
	
	@Autowired
	private TourPackageRepository tourPackageRepository;
	

	/**
     * Create a new Tour Object and persist it to the Database.
     *
     * @param title
     * @param description
     * @param blurb
     * @param price
     * @param duration
     * @param bullets
     * @param keywords
     * @param tourPackageName
     * @param difficulty
     * @param region
     * @return Tour Entity
     */
    public Tour createTour(String title, String description, String blurb, Integer price,
                           String duration, String bullets,
                           String keywords, String tourPackageName, Difficulty difficulty, Region region ) {
    	
        TourPackage tourPackage = tourPackageRepository.findByName(tourPackageName).orElseThrow(()->
             new RuntimeException("Tour package does not exist: " + tourPackageName));

        return tourRepository.save(new Tour(title, description,blurb, price, duration,
                bullets, keywords, tourPackage, difficulty, region));
    }

    /**
     * Calculate the number of Tours in the Database.
     *
     * @return the total.
     */
    public long total() {
        return tourRepository.count();
    }

	
	
	
}
