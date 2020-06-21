package com.greetingapplication.service;

import com.greetingapplication.model.Greeting;
import com.greetingapplication.model.User;

import java.util.List;

public interface IGreetingService {
    Greeting addGreeting(User user);
    Greeting getById(long id);
    List<Greeting> getOverallList();
}
