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
    IPersonService service;

    @BeforeEach
    void setup() {
        service = new PersonService();
        person = new Person("Lucas", "Ezequiel", "lucas@gmailcom",
                "Ipanema", "Male");
    }

    @DisplayName("When create a person with success should return a Person Object")
    @Test
    void testCreatePerson_WhenSuccess_ShouldReturnPersonObject() {
        //When
        Person actual = service.createPerson(person);

        //Then
        assertNotNull(actual, () -> "The createPerson() should not have returned null!");
    }

    @DisplayName("When create a Person with success should contains correct data in return Person Object")
    @Test
    void testCreatePerson_WhenSuccess_ShouldContainsCorrectDataInReturnPersonObject() {
        //When
        Person actual = service.createPerson(person);

        //Then
        assertNotNull(person.getId(), () -> "personId is missing!");

        assertEquals(person.getFirstName(), actual.getFirstName(),
                () -> "The Person firstName is incorrect!");

        assertEquals(person.getLastName(), actual.getLastName(),
                () -> "The Person lastName is incorrect!");

        assertEquals(person.getEmail(), actual.getEmail(),
                () -> "The Person email is incorrect!");

        assertEquals(person.getAddress(), actual.getAddress(),
                () -> "The Person address is incorrect!");

        assertEquals(person.getGender(), actual.getGender(),
                () -> "The Person gender is incorrect!");
    }

    @DisplayName("When create a Person with null e-mail should throw Exception")
    @Test
    void testCreatePerson_WithNullEmail_ShouldThrowIllegalArgumentException() {
        person.setEmail(null);

        var expectedMessage = "The Person e-mail is null or empty!";

        var actual = assertThrows(IllegalArgumentException.class,
                ()-> service.createPerson(person),
                () -> "Empty e-mail should have cause an IllegalArgumentException");

        assertEquals(expectedMessage, actual.getMessage(),
                () -> "Exception error message is incorrect!");
    }


}
