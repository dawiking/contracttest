package com.example.springboot22.contracttest.rest.contract;

import com.example.springboot22.contracttest.ContracttestApplication;
import com.example.springboot22.contracttest.rest.DataService;
import com.example.springboot22.contracttest.rest.MyController;
import com.example.springboot22.contracttest.rest.model.Contact;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import reactor.core.publisher.Mono;

import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
@WebMvcTest(controllers = MyController.class)
@ContextConfiguration(classes = ContracttestApplication.class)
public abstract class ContractBase {
    @MockBean
    private DataService dataService;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void setup() {
        RestAssuredMockMvc.mockMvc(mockMvc);

        when(dataService.getContact())
                .thenReturn(Mono.just(contact()));
    }

    private Contact contact() {
        return Contact.builder().name("David Söder").build();
    }
}
