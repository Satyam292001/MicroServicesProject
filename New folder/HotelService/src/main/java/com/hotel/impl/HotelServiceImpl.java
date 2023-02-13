package com.hotel.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.entities.Hotel;
import com.hotel.exception.ResourceNotFoundException;
import com.hotel.repository.HotelRepository;
import com.hotel.service.HotelService;

@Service
public class HotelServiceImpl implements HotelService {

	@Autowired
	private HotelRepository hotelrepositroy;
	
	@Override
	public Hotel create(Hotel hotel) {
		String randomId=UUID.randomUUID().toString();
		hotel.setHotelId(randomId);
		return hotelrepositroy.save(hotel);
	}

	@Override
	public List<Hotel> getAllHotel() {
		return hotelrepositroy.findAll();
	}

	@Override
	public Hotel getSingleHotel(String hotelId) {
		return hotelrepositroy.findById(hotelId).orElseThrow(() -> new ResourceNotFoundException("id not exit"+hotelId));
	}

	
}
