package com.greetingapplication.service;

import com.greetingapplication.model.Greeting;
import com.greetingapplication.model.User;

public interface IGreetingService {
    Greeting addGreeting(User user);
    Greeting getById(long id);
}
