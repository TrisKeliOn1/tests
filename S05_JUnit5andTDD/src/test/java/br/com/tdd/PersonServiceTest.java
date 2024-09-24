package br.com.tdd;

import br.com.tdd.model.Person;
import br.com.tdd.service.IPersonService;
import br.com.tdd.service.PersonService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PersonServiceTest {

    Person person;

    @BeforeEach
    void setup() {
        person = new Person(
                "Keith",
                "Moon",
                "kmoon@tdd.com.br",
                "Wembley - UK",
                "Male"
        );
    }

    @DisplayName("When Create a Person with Success Should Return a Person Object")
    @Test
    void testCreatePerson_WhenSuccess_ShouldReturnPersonObject() {

        // Given
        IPersonService service = new PersonService();

        // When
        Person actual = service.createPerson(person);

        //Then
        assertNotNull(actual, () -> "The createPerson() should not have returned null!");
    }

    @DisplayName("When Create a Person with Success Should Contains Valid Fields in Returned Person Object")
    @Test
    void testCreatePerson_WhenSuccess_ShouldContainsValidFieldsInReturnedPersonObject() {

        // Given
        IPersonService service = new PersonService();

        // When
        Person actual = service.createPerson(person);

        //Then
        assertNotNull(person.getId(), () -> "Person ID is Missing");
        assertEquals(person.getFirstName(), actual.getFirstName() , () -> "The Person FirstName is Different!");
        assertEquals(person.getLastName(), actual.getLastName() , () -> "The Person LastName is Different!");
        assertEquals(person.getAddress(), actual.getAddress() , () -> "The Person Address is Different!");
        assertEquals(person.getGender(), actual.getGender() , () -> "The Person Gender is Different!");
        assertEquals(person.getEmail(), actual.getEmail() , () -> "The Person Email is Different!");
    }

    @DisplayName("When Create a Person with null email Should throw Exception ")
    @Test
    void testCreatePerson_WithNullEmail_ShouldThrowIllegalArgumentException() {

        // Given
        IPersonService service = new PersonService();
        person.setEmail(null);

        // When
        assertThrows(IllegalArgumentException.class,
                () -> service.createPerson(person),
                () -> "Empty Email should have cause an IllegalArgumentException!");
    }

}
