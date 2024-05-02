package br.com.ezequiel.service;

import br.com.ezequiel.model.Person;
import br.com.ezequiel.service.IPersonService;
import br.com.ezequiel.service.PersonService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PersonServiceTest {

    Person person;

    @BeforeEach
    void setup() {
        person = new Person("Lucas", "Ezequiel", "lucas@gmailcom",
                "Ipanema", "Male");
    }

    @DisplayName("When create a person with success should return a Person Object")
    @Test
    void testCreatePerson_WhenSuccess_ShouldReturnPersonObject() {
        //Given
        IPersonService service = new PersonService();

        //When
        Person actual = service.createPerson(person);

        //Then
        assertNotNull(actual, () -> "The createPerson() should not have returned null!");
    }

    @DisplayName("When create a person with success should contains firstName in return Person Object")
    @Test
    void testCreatePerson_WhenSuccess_ShouldContainsCorrectDataInReturnPersonObject() {
        //Given
        IPersonService service = new PersonService();

        //When
        Person actual = service.createPerson(person);

        //Then
        assertEquals(person.getFirstName(), actual.getFirstName(),
                () -> "The firstName is differet!");

        assertEquals(person.getLastName(), actual.getLastName(),
                () -> "The lastName is differet!");

        assertEquals(person.getEmail(), actual.getEmail(),
                () -> "The email is differet!");

        assertEquals(person.getAddress(), actual.getAddress(),
                () -> "The address is differet!");

        assertEquals(person.getGender(), actual.getGender(),
                () -> "The gender is differet!");
    }


}
