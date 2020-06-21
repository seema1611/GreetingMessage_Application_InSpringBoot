package com.greetingapplication.service.implementors;

import com.greetingapplication.exception.GreetingException;
import com.greetingapplication.model.Greeting;
import com.greetingapplication.model.User;
import com.greetingapplication.repository.IGreetingRepository;
import com.greetingapplication.service.IGreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class GreetingService implements IGreetingService {
    private static final String template = "Hello  %s !";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private IGreetingRepository greetingRepository;

    @Override
    public Greeting addGreeting(User user) {
        String message = String.format(template, (user.toString().isEmpty()) ? "HELLO WORLD" : user.toString());
        Greeting greeting = new Greeting();
        greeting.setIncrementAndGet(counter.incrementAndGet());
        greeting.setFormat(message);
        return greetingRepository.save(greeting);
    }

    @Override
    public Greeting getById(long id) {
        return greetingRepository.findById(id)
                .orElseThrow(() -> new GreetingException("No Greeting Found", GreetingException.ExceptionType.USER_NOT_FOUND));
    }

    @Override
    public List<Greeting> getOverallList() {
        return greetingRepository.findAll();
    }

    @Override
    public Greeting getMessageAfterModification(long id, String fName, String lName) {
        Greeting update = greetingRepository.findById(id).orElseThrow(() -> new GreetingException("No Greeting Found", GreetingException.ExceptionType.USER_NOT_FOUND));
        update.setFormat("Hello " + fName + " " + lName);
        return greetingRepository.save(update);
    }
}
