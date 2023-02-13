package com.user.impl;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.user.entities.Rating;
import com.user.entities.User;
import com.user.exception.ResourceNotFoundException;
import com.user.repository.UserRepository;
import com.user.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userrepository;

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public User create(User user) {
		String randomId = UUID.randomUUID().toString();
		user.setUserId(randomId);
		return userrepository.save(user);
	}

	@Override
	public List<User> getAllUser() {
		return userrepository.findAll();
	}

	@Override
	public User getSingleUser(String userId) {
		User user = userrepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("id not exit on server" + userId));

		Rating[] ratingObject = restTemplate.getForObject("localhost:8086/ratings/users/" + user.getUserId(),
				Rating[].class);

		List<Rating> listObject = Arrays.stream(ratingObject).toList();

//		Rating[] forObject= restTemplate.getForObject("localhost:8086/ratings/users/"+user.getUserId(), Rating[].class);
//		System.out.println(forObject);
//		
////		user.setRatings(forObject);
//		
////		forObject.stream().map(t -> {
////			//api call to hotel service and get the hotel
////			//set the hotel rating
////			//return hotel
////		});
//		
//		for (Rating rating : forObject) {
//			ResponseEntity<Hotel> forEntity= restTemplate.getForEntity("localhost:8083"+rating.getHotelId(), Hotel.class);
//			 Hotel hotel=forEntity.getBody();
//			System.out.println(forEntity.getStatusCode());
//			
//			rating.setHotelId(hotel);
//			
//			return rating;
//		}

		user.setRatings(listObject);

		return user;
	}

}
