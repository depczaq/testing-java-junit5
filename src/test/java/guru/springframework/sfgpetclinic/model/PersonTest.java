package guru.springframework.sfgpetclinic.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest implements TestNamePrinter {

    @Test
    void testGroupAssertions() {
        // given
        Person person = new Person(1L, "Jan", "Kowalski");

        // then
        assertAll("Group assertion",
                () -> assertEquals(1, person.getId(), "Id failed"),
                () -> assertNotEquals("Janek", person.getFirstName(), "First name failed"),
                () -> assertEquals("Kowal", person.getLastName(), "Last name failed")
        );
    }

    @RepeatedTest(value = 5, name = "{displayName} {currentRepetition} of {totalRepetitions}")
    @DisplayName("My Repeated Test")
    void repeatedTest() {

    }
}