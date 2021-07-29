package com.example;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class DataFormatter {

    private static String apiKey;

    @Value("${apiKey}")
    public void setApiKey(String value) {
        this.apiKey = value;
    }

    public static List<Person> getFormattedData(String dataUrl, String sheetName) throws Exception{

        final String baseUrl = "https://sheets.googleapis.com/v4/spreadsheets/";
        
        //Get the part of the URL after "/d" (the spreadsheetId is the next value after "/d")
        final String dataUrlSplit = dataUrl.split("d/")[1];
        //Removing anything in the remaining URL that is after the spreadsheetId to leave just the spreadsheetId
        final String spreadsheetId = dataUrlSplit.split("/")[0];

        final String url = baseUrl + spreadsheetId + "/values/" + sheetName + "?key=" + apiKey;

        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(url, String.class);

        final ObjectMapper mapper = new ObjectMapper();
        SheetResponse sheetResponse = mapper.readValue(result, SheetResponse.class);

        List<Person> persons = new ArrayList<>();
        //Start the iteration from after the header row
        for(int i = 1; i < sheetResponse.getValues().size(); i++) {
            Person person = new Person();

            person.setFirstname(sheetResponse.getValues().get(i).get(0));
            person.setSurname(sheetResponse.getValues().get(i).get(1));
            person.setAddress1(sheetResponse.getValues().get(i).get(2));
            person.setAddress2(sheetResponse.getValues().get(i).get(3));
            person.setCity(sheetResponse.getValues().get(i).get(4));
            person.setState(sheetResponse.getValues().get(i).get(5));
            person.setPostcode(sheetResponse.getValues().get(i).get(6));
            person.setCountrycode(sheetResponse.getValues().get(i).get(7));
            person.setGender(sheetResponse.getValues().get(i).get(8));
            person.setDateofbirth(sheetResponse.getValues().get(i).get(9));

            persons.add(person);
        }

        return persons;
    }
    
}
