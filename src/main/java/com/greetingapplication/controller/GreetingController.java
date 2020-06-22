package com.greetingapplication.controller;

import com.greetingapplication.model.Greeting;
import com.greetingapplication.model.User;
import com.greetingapplication.service.IGreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GreetingController {

    @Autowired
    IGreetingService iGreetingService;

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "fName", defaultValue = "Hello world") String firstName,
                             @RequestParam(value = "lName") String lastName) {
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        return iGreetingService.addGreeting(user);
    }

    @GetMapping("/findgreetingbyid")
    public Greeting getGreetingById(@RequestParam(value = "id") long id) {
        return iGreetingService.getById(id);
    }

    @GetMapping("/listofgreetings")
    public List<Greeting> getOverallGreetingList() {
        return iGreetingService.getOverallList();
    }

    @PutMapping("/editgreeting/{id}")
    public Greeting getModifiedMessage(@PathVariable long id, @RequestParam(value = "fName") String fName,
                                       @RequestParam(value = "lName") String lName) {
        return iGreetingService.getMessageAfterModification(id, fName, lName);
    }

    @DeleteMapping("/deletebyidandgetupdatedlist")
    public List<Greeting> deleteByIdAndGetUpdatedList(@RequestParam(value = "id") long id) {
        return iGreetingService.getUpdatedListAfterDeletionById(id);
    }
}