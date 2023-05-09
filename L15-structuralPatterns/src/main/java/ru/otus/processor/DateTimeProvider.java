package ru.otus.processor;

import java.time.*;

public interface DateTimeProvider {
    public LocalDateTime getDate();
}
