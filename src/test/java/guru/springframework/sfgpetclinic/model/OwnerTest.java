package guru.springframework.sfgpetclinic.model;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OwnerTest {

    @Test
    @Disabled
    void nestedAssertions() {
        Owner owner = new Owner(2L, "Tomek", "Wiśniewski");
        owner.setCity("Miasto");
        owner.setTelephone("123456789");

        assertAll("Properties test",
                () -> assertAll("Person properties test",
                        () -> assertEquals(2, owner.getId(), "Id failed"),
                        () -> assertNotEquals("Janek", owner.getFirstName(), "First name failed"),
                        () -> assertEquals("Wiśniewski", owner.getLastName(), "Last name failed")
                ),
                () -> assertAll("Owner properties test",
                        () -> assertEquals("Miasto", owner.getCity(), "City not match"),
                        () -> assertEquals("123456789", owner.getTelephone(), "Telephone not match")
                )
        );
    }
}