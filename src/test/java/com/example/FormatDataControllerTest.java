package com.example;

import com.jayway.restassured.RestAssured;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class FormatDataControllerTest {
    @Value("${local.server.port}")
    int port;

    @Before
    public void setUp() throws Exception {
        RestAssured.port = port;
    }

	@Autowired
	private MockMvc mockMvc;

    @Test
    public void formatData() throws Exception {        

        Person fred = new Person("Fred", "Smith", "Customs House", "1 Long Street", "Glasgow", "Glasgow",	"G10 1AA", "UK", "M", "1/1/1970");
        Person bob = new Person("Bob", "Long", "2 Short Street", "", "Southend", "Essex",	"SS0 8BB", "UK", "M", "2/2/1971");

        List<Person> persons = new ArrayList<>();
        persons.add(fred);        
        persons.add(bob);   

        final ObjectMapper mapper = new ObjectMapper();
        final String expectedResponse = mapper.writeValueAsString(persons);

        MvcResult result = mockMvc.perform(get("/formatData")
            .param("dataUrl", "https://docs.google.com/spreadsheets/d/1H91tUzQFoB4LO5PcEGTh-yrSzOqri8oBvHBq78DGXr4/edit?usp=sharing")
            .param("sheetName", "Sheet1"))
            .andExpect(status().isOk()).andReturn();
        String actualResponse = result.getResponse().getContentAsString();
        
        assertEquals(expectedResponse, actualResponse);
    }

    @Test
    public void formatData_and_sortDataBySurname() throws Exception {        

        Person fred = new Person("Fred", "Smith", "Customs House", "1 Long Street", "Glasgow", "Glasgow",	"G10 1AA", "UK", "M", "1/1/1970");
        Person bob = new Person("Bob", "Long", "2 Short Street", "", "Southend", "Essex",	"SS0 8BB", "UK", "M", "2/2/1971");
        Person nancy = new Person("Nancy", "Bayliss", "3 Lombard Street", "", "Brighton", "East Sussex", "B23 4CC", "GB", "F", "3/3/1973");

        List<Person> persons = new ArrayList<>();
        //adding in order of surname (a-z)
        persons.add(nancy);
        persons.add(bob);        
        persons.add(fred);        

        final ObjectMapper mapper = new ObjectMapper();
        final String expectedResponse = mapper.writeValueAsString(persons);

        MvcResult result = mockMvc.perform(get("/formatData")
            .param("dataUrl", "https://docs.google.com/spreadsheets/d/1QUJbWwD0S_nOxwOuQZp4Gl8rsqNd_cfMMDh4-5nNWdE/edit#gid=0")
            .param("sheetName", "Sheet1")
            .param("sortBy", "surname"))
            .andExpect(status().isOk()).andReturn();
        String actualResponse = result.getResponse().getContentAsString();

        assertEquals(expectedResponse, actualResponse);
    }

    @Test
    public void formatData_and_sortDataByCity() throws Exception {        

        Person fred = new Person("Fred", "Smith", "Customs House", "1 Long Street", "Glasgow", "Glasgow",	"G10 1AA", "UK", "M", "1/1/1970");
        Person bob = new Person("Bob", "Long", "2 Short Street", "", "Southend", "Essex",	"SS0 8BB", "UK", "M", "2/2/1971");
        Person nancy = new Person("Nancy", "Bayliss", "3 Lombard Street", "", "Brighton", "East Sussex", "B23 4CC", "GB", "F", "3/3/1973");

        List<Person> persons = new ArrayList<>();
        //adding in order of city name (a-z)
        persons.add(nancy);
        persons.add(fred);        
        persons.add(bob);        

        final ObjectMapper mapper = new ObjectMapper();
        final String expectedResponse = mapper.writeValueAsString(persons);

        MvcResult result = mockMvc.perform(get("/formatData")
            .param("dataUrl", "https://docs.google.com/spreadsheets/d/1QUJbWwD0S_nOxwOuQZp4Gl8rsqNd_cfMMDh4-5nNWdE/edit#gid=0")
            .param("sheetName", "Sheet1")
            .param("sortBy", "city"))
            .andExpect(status().isOk()).andReturn();
        String actualResponse = result.getResponse().getContentAsString();

        assertEquals(expectedResponse, actualResponse);
    }

}