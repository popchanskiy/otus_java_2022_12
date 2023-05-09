package ru.otus.processor;

import ru.otus.model.*;

public class ProcessorReplaceFields implements Processor {
    @Override
    public Message process(Message message) {
        return message.toBuilder()
                .field11(message.getField12())
                .field12(message.getField11())
                .build();
    }
}
