package ua.foxminded.pinchuk.javaspring.schoolconsoleapp.task1.view;

import ua.foxminded.pinchuk.javaspring.schoolconsoleapp.task1.view.impl.IODataImpl;

public class IODataFactory {

    private static final IODataFactory INSTANCE = new IODataFactory();

    private IODataFactory() {
    }

    public static IODataFactory getInstance(){
        return INSTANCE;
    }
    private static IOData ioData = new IODataImpl();

    public static IOData getIoData() {
        return ioData;
    }
}
