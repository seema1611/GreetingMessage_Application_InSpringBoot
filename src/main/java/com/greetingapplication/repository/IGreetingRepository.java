package com.greetingapplication.repository;

import com.greetingapplication.model.Greeting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IGreetingRepository extends JpaRepository<Greeting, Long> {
}
