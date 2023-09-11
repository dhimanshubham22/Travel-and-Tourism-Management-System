package com.system.toursandtravelmanagement.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.system.toursandtravelmanagement.DTO.BookingsDTO;
import com.system.toursandtravelmanagement.DTO.UserRegisteredDTO;
import com.system.toursandtravelmanagement.model.Bookings;
import com.system.toursandtravelmanagement.model.User;

public interface DefaultUserService extends UserDetailsService{

	User save(UserRegisteredDTO userRegisteredDTO);

	Bookings updateBookings(BookingsDTO bookingDTO,UserDetails user);
	
	void sendEmail(BookingsDTO bookingDTO, User users, String nameGenrator);

}