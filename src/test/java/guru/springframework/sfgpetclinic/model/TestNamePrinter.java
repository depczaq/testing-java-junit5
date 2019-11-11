package guru.springframework.sfgpetclinic.model;

import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public interface TestNamePrinter {

    @BeforeEach
    default void setUpAll(TestInfo testInfo, RepetitionInfo repetitionInfo) {
        System.out.printf("TestNamePrinter: %s Repetition %d of %d",
                testInfo.getDisplayName(), repetitionInfo.getCurrentRepetition(), repetitionInfo.getTotalRepetitions());
    }
}
