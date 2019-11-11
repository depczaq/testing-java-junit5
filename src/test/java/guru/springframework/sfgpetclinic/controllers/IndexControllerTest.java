package guru.springframework.sfgpetclinic.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

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
}