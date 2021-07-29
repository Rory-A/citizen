package com.example;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class DataSorter {

    public static void sortData(List<Person> persons, String sortBy) {
        if(sortBy.equals("surname")){
            Collections.sort(persons, new Comparator<Person>() {
                @Override
                public int compare(Person person, Person otherPerson) {
                  return person.getSurname().compareTo(otherPerson.getSurname());
                }
            });          
        }
        else if(sortBy.equals("city")){
            Collections.sort(persons, new Comparator<Person>() {
                @Override
                public int compare(Person person, Person otherPerson) {
                  return person.getCity().compareTo(otherPerson.getCity());
                }
            });          
        }
    }

}
