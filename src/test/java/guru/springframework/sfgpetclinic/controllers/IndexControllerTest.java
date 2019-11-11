package guru.springframework.sfgpetclinic.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeFalse;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

class IndexControllerTest {

    private IndexController controller;

    @BeforeEach
    void setUp() {
        controller = new IndexController();
    }

    @Test
    void oopsHandlerThrowsException() {
        assertThrows(
                RuntimeException.class,
                () -> controller.oopsHandler(true),
                "RuntimeException should be thrown"
        );
    }

    @Test
    void oopsHandlerDoesNotThrowException() {
        assertDoesNotThrow(
                () -> controller.oopsHandler(false),
                "RuntimeException should be thrown"
        );
    }

    @Test
    @Disabled("Blocks main JUnit thread for 5 seconds.")
    void testTimeoutAssertion() {
        assertTimeout(Duration.ofMillis(100), () -> Thread.sleep(5000));
    }

    @Test
    void testTimeoutPreemptivelyAssertion() {
        // kills timeouted thread
        assertTimeoutPreemptively(Duration.ofMillis(100), () -> Thread.sleep(5000));
    }

    @Test
    void testAssumptions() {
        assumeTrue(true, "Assumption should be fulfilled");
        assumeFalse(false, "Assumption should be fulfilled");
        assumeTrue(false, "Assumption disabled test execution.");

        fail("This point should not be reached.");
    }
}