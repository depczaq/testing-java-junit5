package guru.springframework.sfgpetclinic.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
}