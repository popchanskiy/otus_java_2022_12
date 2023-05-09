package ru.otus.handler;

import ru.otus.listener.*;
import ru.otus.model.*;

public interface Handler {
    Message handle(Message msg);

    void addListener(Listener listener);

    void removeListener(Listener listener);
}
