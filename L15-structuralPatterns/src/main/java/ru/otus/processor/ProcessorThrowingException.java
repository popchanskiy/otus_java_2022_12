package ru.otus.processor;

import ru.otus.exception.*;
import ru.otus.model.*;

public class ProcessorThrowingException implements Processor {

    private final DateTimeProvider dateTimeProvider;

    public ProcessorThrowingException(DateTimeProvider dateTimeProvider) {
        this.dateTimeProvider = dateTimeProvider;
    }

    @Override
    public Message process(Message message) {
        if (dateTimeProvider.getDate().getSecond() % 2 == 0) {
            throw new EvenException("Even datatime accepted");
        }
        return message;
    }
}


