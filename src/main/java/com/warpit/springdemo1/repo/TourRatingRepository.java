package com.warpit.springdemo1.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.warpit.springdemo1.domain.TourRating;
import com.warpit.springdemo1.domain.TourRatingPk;

import java.util.List;
import java.util.Optional;

/**
 * Tour Rating Repository Interface
 */

@RepositoryRestResource(exported = false)
public interface TourRatingRepository extends PagingAndSortingRepository<TourRating, TourRatingPk> {

    /**
     * Lookup all the TourRatings for a tour.
     *
     * @param tourId is the tour Identifier
     * @return a List of any found TourRatings
     */
    List<TourRating> findByPkTourId(Integer tourId);

    /**
     * Lookup a TourRating by the TourId and Customer Id
     * @param tourId tour identifier
     * @param customerId customer identifier
     * @return Optional of found TourRatings.
     */
    Optional<TourRating> findByPkTourIdAndPkCustomerId(Integer tourId, Integer customerId);
    
    
    /**
     * I ran into the same issue when I had named an embedded ID as MyCompositePK and tried writing f
     * indByMyCompositePKUserId(Long userId). 
     * The point is, it needs to be camel case as well for the CRUD repository, 
     * so as to differentiate between the table properties when creating the query out of your method.
     * So, it has to be MyCompositePk and findByMyCompositePkUserId(Long userId)
     * @param tourId
     * @param pageable
     * @return
     */
    
    Page<TourRating> findByPkTourId(Integer tourId,Pageable pageable);
}