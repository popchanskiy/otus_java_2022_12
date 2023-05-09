package ru.otus.listener.homework;

import ru.otus.listener.*;
import ru.otus.model.*;

import java.util.*;

public class HistoryListener implements Listener, HistoryReader {
    Map<Long, Message> messageHistory = new HashMap<>();

    @Override
    public void onUpdated(Message msg) {
        Message copedMsg = msg.copy(msg);
        messageHistory.put(copedMsg.getId(), copedMsg);
    }

    @Override
    public Optional<Message> findMessageById(long id) {
        return Optional.of(messageHistory.get(id));
    }
}
