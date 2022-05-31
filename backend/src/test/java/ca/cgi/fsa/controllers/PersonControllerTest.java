package ca.cgi.fsa.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;

import ca.cgi.fsa.entities.Person;
import ca.cgi.fsa.repositories.PersonRepository;

@WebMvcTest(PersonController.class)
public class PersonControllerTest {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper mapper;

    @MockBean
    PersonRepository patientRecordRepository;

    Person RECORD_1 = new Person("Greg", "Pascucci", "greg.pascucci@gmail.com");
    Person RECORD_2 = new Person("Conan", "Barbarian", "greg.pascucci@gmail.com");

    @Test
    public void getAllPersonRecords_success() throws Exception {
        List<Person> records = new ArrayList<>(Arrays.asList(RECORD_1, RECORD_2));

        Mockito.when(patientRecordRepository.findAll()).thenReturn(records);

        mockMvc.perform(MockMvcRequestBuilders
                .get("/people")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[1].firstName", is("Conan")));
    }
}