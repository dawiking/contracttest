package com.example.springboot22.contracttest.rest;

import com.example.springboot22.contracttest.rest.model.Contact;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class MyController {

    private final DataService dataService;

    @GetMapping("/contact")
    public Mono<Contact> contactDetails() {
        return dataService.getContact();
    }

}