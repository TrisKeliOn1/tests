package br.com.tdd;

import br.com.tdd.model.Person;
import br.com.tdd.service.IPersonService;
import br.com.tdd.service.PersonService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PersonServiceTest {

    @DisplayName("When Create a Person with Success Should Return a Person Object")
    @Test
    void testCreatePerson_WhenSuccess_ShouldReturnPersonObject() {

        // Given
        IPersonService service = new PersonService();

        Person person = new Person(
                "Keith",
                "Moon",
                "kmoon@tdd.com.br",
                "Wembley - UK",
                "Male"
        );

        // When
        Person actual = service.createPerson(person);

        //Then
        assertNotNull(actual, () -> "The createPerson() should not have returned null!");
    }

    @DisplayName("When Create a Person with Success Should Contains FirstName in Returned Person Object")
    @Test
    void testCreatePerson_WhenSuccess_ShouldContainsFirstNameInReturnedPersonObject() {

        // Given
        IPersonService service = new PersonService();

        Person person = new Person(
                "Keith",
                "Moon",
                "kmoon@tdd.com.br",
                "Wembley - UK",
                "Male"
        );

        // When
        Person actual = service.createPerson(person);

        //Then
        assertEquals(person.getFirstName(), actual.getFirstName() , () -> "The firstName is Different!");
    }
}
