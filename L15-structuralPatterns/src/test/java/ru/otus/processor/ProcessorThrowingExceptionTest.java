package ru.otus.processor;

import org.junit.jupiter.api.*;
import ru.otus.exception.*;
import ru.otus.model.*;

import java.time.*;

import static org.junit.jupiter.api.Assertions.*;

public class ProcessorThrowingExceptionTest {
    @Test
    void throwingExceptionTest() {
        var message = new Message.Builder(1L).field8("field8").build();
        var processorEvenTime = new ProcessorThrowingException(() -> LocalDateTime.parse("2018-12-03T12:39:10"));
        var processorOddTime = new ProcessorThrowingException(() -> LocalDateTime.parse("2018-12-03T12:39:11"));
        assertThrows(EvenException.class, () -> processorEvenTime.process(message));
        assertDoesNotThrow(() -> processorOddTime.process(message));
    }
}
