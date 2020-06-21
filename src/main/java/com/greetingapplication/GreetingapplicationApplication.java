package com.greetingapplication;

import com.greetingapplication.model.Greeting;
import com.greetingapplication.model.User;
import com.greetingapplication.repository.IGreetingRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GreetingapplicationApplication {

    public static void main(String[] args) {
        SpringApplication.run(GreetingapplicationApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(IGreetingRepository repository){
        return args -> {
          repository.save(new Greeting());
        };
    }
}
