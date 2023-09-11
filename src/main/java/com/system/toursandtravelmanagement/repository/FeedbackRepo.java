package com.system.toursandtravelmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.system.toursandtravelmanagement.model.Feedback;

public interface FeedbackRepo extends JpaRepository<Feedback, Integer>{

}
