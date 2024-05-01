package br.com.ezequiel.service;

import br.com.ezequiel.model.Person;
import br.com.ezequiel.service.IPersonService;
import br.com.ezequiel.service.PersonService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PersonServiceTest {

    @DisplayName("When create a person with success should return a Person Object")
    @Test
    void testCreatePerson_WhenSuccess_ShouldReturnPersonObject() {
        //Given
        IPersonService service = new PersonService();
        Person person = new Person("Lucas", "Ezequiel", "lucas@gmailcom",
                "Ipanema", "Male");

        //When
        Person actual = service.createPerson(person);

        //Then
        assertNotNull(actual, () -> "The createPerson() should not have returned null!");
    }

    @DisplayName("When create a person with success should contains firstName in return Person Object")
    @Test
    void testCreatePerson_WhenSuccess_ShouldContainsFirstNameInReturnPersonObject() {
        //Given
        IPersonService service = new PersonService();
        Person person = new Person("Lucas", "Ezequiel", "lucas@gmailcom",
                "Ipanema", "Male");

        //When
        Person actual = service.createPerson(person);

        //Then
        assertEquals(person.getFirstName(), actual.getFirstName(),
                () -> "The firstName is differet!");
    }


}
