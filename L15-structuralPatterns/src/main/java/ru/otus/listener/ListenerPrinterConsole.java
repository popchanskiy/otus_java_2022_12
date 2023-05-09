package ru.otus.listener;

import ru.otus.model.*;

public class ListenerPrinterConsole implements Listener {

    @Override
    public void onUpdated(Message msg) {
        var logString = String.format("msg:%s", msg);
        System.out.println(logString);
    }
}
