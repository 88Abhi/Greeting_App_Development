package com.demo.mygreetingapp.repository;

import com.demo.mygreetingapp.entity.GreetingMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GreetingRepository extends JpaRepository<GreetingMessage, Long> {
	// JpaRepository provides built-in save(), findAll(), findById(), etc.
}