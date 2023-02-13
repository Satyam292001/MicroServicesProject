package com.rating.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rating.entities.Rating;
import com.rating.repository.RatingRepository;
import com.rating.service.RatingService;

@Service
public class RatingServiceImpl  implements RatingService{

	@Autowired
	private RatingRepository ratingrepository;
	
	@Override
	public Rating create(Rating rating) {
		String randomId=UUID.randomUUID().toString();
		rating.setRatingId(randomId);
		return ratingrepository.save(rating);
	}

	@Override
	public List<Rating> getAll() {
		return ratingrepository.findAll();
	}

	@Override
	public List<Rating> getRatingByUserId(String userId) {
		return ratingrepository.findByUserId(userId);
	}

	@Override
	public List<Rating> getRatingByHotelId(String hotelId) {
		return ratingrepository.findByHotelId(hotelId);
	}

}
