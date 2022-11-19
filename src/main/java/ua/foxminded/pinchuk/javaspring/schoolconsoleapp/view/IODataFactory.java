package ua.foxminded.pinchuk.javaspring.schoolconsoleapp.view;

import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.view.impl.IODataImpl;

public class IODataFactory {
    private static final IOData IO_DATA = new IODataImpl();

    public static IOData getIoData() {
        return IO_DATA;
    }
}
