package com.system.toursandtravelmanagement.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.system.toursandtravelmanagement.model.Bookings;




public interface BookingsRepository extends JpaRepository<Bookings, Integer> {

	List<Bookings> findByUserId(int userId);
	
}
