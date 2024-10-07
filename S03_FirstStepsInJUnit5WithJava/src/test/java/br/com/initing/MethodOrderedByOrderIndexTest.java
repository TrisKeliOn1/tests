package br.com.initing;

import org.junit.jupiter.api.*;

//@Order(3)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MethodOrderedByOrderIndexTest {

    StringBuilder actualValue = new StringBuilder("");

    @AfterEach
    void afterEach() {
        System.out.println("The actual value is: " + actualValue);
    }

    @Test
    @Order(1)
    void testC() {
        System.out.println("Running test C");
        actualValue.append("1");
    }

    @Test
    @Order(2)
    void testD() {
        System.out.println("Running test D");
        actualValue.append("2");
    }

    @Test
    @Order(3)
    void testA() {
        System.out.println("Running test A");
        actualValue.append("3");
    }

    @Test
    @Order(4)
    void testB() {
        System.out.println("Running test B");
        actualValue.append("4");
    }
}
