package com.example.springboot22.contracttest.rest;

import com.example.springboot22.contracttest.rest.model.Contact;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class DataService {

    public Mono<Contact> getContact() {
        return Mono.just(contact());
    }

    private Contact contact() {
        return Contact.builder().build();
    }
}
